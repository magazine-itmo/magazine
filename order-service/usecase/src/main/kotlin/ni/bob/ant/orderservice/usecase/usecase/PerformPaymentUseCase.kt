package ni.bob.ant.orderservice.usecase.usecase

import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.Order
import ni.bob.ant.orderservice.core.entity.OrderState
import ni.bob.ant.orderservice.usecase.conf.UseCase
import ni.bob.ant.orderservice.usecase.dto.OrderDto
import ni.bob.ant.orderservice.usecase.dto.toDto
import ni.bob.ant.orderservice.usecase.exceptions.notFound
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@UseCase
class PerformPaymentUseCase(
        val paymentRepository: PaymentRepository,
        val messageDistributor: MessageDistributor
) {
    fun execute(orderId: Long): OrderDto {
        val order = paymentRepository.findOrderById(Identity(orderId)) ?: notFound<Order>(orderId)
        if (order.state == OrderState.Collecting) {
            val isSuccess = paymentRepository.performPayment(Identity(orderId), order.totalCost)
            if (isSuccess) {
                order.toState(OrderState.Paid)
            } else {
                order.toState(OrderState.Failed)
                for (orderItem in order.orderItems) {
                    messageDistributor.send(orderItem.identity.value, orderItem.quantity)
                }
            }
        }
        return paymentRepository.save(order).toDto()
    }

    interface PaymentRepository {
        fun findOrderById(identity: Identity): Order?
        // I'm not sure the payment performing should be declared in repository,
        // but mne posrat' because it's really convenient in this case
        fun performPayment(identity: Identity, totalCost: Long): Boolean

        fun save(order: Order): Order
    }


    @Component
    class MessageDistributor(
            val kafkaTemplate: KafkaTemplate<String, Message>
    ) {
        fun send(itemId: Long, quantity: Int) {
            kafkaTemplate.send("Orders", Message(itemId, quantity))
        }
    }

    data class Message(
            val itemId: Long,
            val quantity: Int
    )
}
