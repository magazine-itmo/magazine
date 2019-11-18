package ni.bob.ant.orderservice.usecase.usecase

import ni.bob.ant.orderservice.usecase.conf.UseCase
import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.Order
import ni.bob.ant.orderservice.core.entity.OrderState
import ni.bob.ant.orderservice.usecase.dto.OrderDto
import ni.bob.ant.orderservice.usecase.dto.toDto
import ni.bob.ant.orderservice.usecase.exceptions.TransitionIsNotAllowed
import ni.bob.ant.orderservice.usecase.exceptions.notFound

@UseCase
class ChangeOrderStatusUseCase(
        private val ordersRepository: OrdersRepository,
        private val orderStateRepository: OrderStateRepository
) {

    fun execute(id: Long, status: String): OrderDto {
        val order = ordersRepository.findOrderById(Identity(id)) ?: notFound<Order>(id)
        val requestedState = orderStateRepository.findStateByName(status) ?: notFound<OrderState>(status)
        if (!order.isTransitionAllowed(requestedState)) {
            throw TransitionIsNotAllowed(id, requestedState.toString())
        }
        order.toState(requestedState)
        return order.toDto()
    }

    interface OrdersRepository {
        fun findOrderById(identity: Identity): Order?
    }

    interface OrderStateRepository {
        fun findStateByName(status: String): OrderState?
    }
}
