package ni.bob.ant.orderservice.usecase.dto

import ni.bob.ant.orderservice.core.entity.Order
import ni.bob.ant.orderservice.core.entity.OrderItem
import ni.bob.ant.orderservice.core.entity.OrderState

data class OrderDto(
        val id: Long,
        val state: String,
        val totalCost: Long,
        val totalAmount: Int,
        val items: List<OrderItemDto>
)

fun Order.toDto() = OrderDto(
        id = this.identity.value,
        state = this.state.toString(),
        totalCost = this.totalCost,
        totalAmount = this.totalAmount,
        items = this.orderItems.map { it.toDto() }
)

data class OrderItemDto(
        val id: Long,
        val name: String,
        val amount: Int
)

private fun OrderItem.toDto() = OrderItemDto(
        id = this.stockItem.identity.value,
        name = this.stockItem.name,
        amount = this.quantity
)

data class ItemDto(
        val id: Long,
        val amount: Int
)
