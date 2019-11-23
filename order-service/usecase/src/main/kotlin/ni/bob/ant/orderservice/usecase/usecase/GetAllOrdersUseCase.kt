package ni.bob.ant.orderservice.usecase.usecase

import ni.bob.ant.orderservice.core.entity.Order
import ni.bob.ant.orderservice.usecase.conf.UseCase
import ni.bob.ant.orderservice.usecase.dto.OrderDto
import ni.bob.ant.orderservice.usecase.dto.toDto

@UseCase
class GetAllOrdersUseCase(
    val orderRepository: OrderRepository
) {
    fun execute(): List<OrderDto> {
        return orderRepository.findAll().map { it.toDto() }
    }

    interface OrderRepository {
        fun findAll(): List<Order>
    }
}
