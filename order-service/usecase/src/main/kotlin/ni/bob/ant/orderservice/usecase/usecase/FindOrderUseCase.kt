package ni.bob.ant.orderservice.usecase.usecase

import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.Order
import ni.bob.ant.orderservice.usecase.conf.UseCase
import ni.bob.ant.orderservice.usecase.dto.OrderDto
import ni.bob.ant.orderservice.usecase.dto.toDto
import ni.bob.ant.orderservice.usecase.exceptions.notFound

@UseCase
class FindOrderUseCase(
        private val orderRepository: OrderRepository
) {
    fun execute(id: Long): OrderDto {
        return orderRepository.findOrderById(Identity(id))?.toDto() ?: notFound<Order>(id)
    }

    interface OrderRepository {
        fun findOrderById(identity: Identity): Order?
    }
}

