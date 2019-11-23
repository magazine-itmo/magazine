package ni.bob.ant.orderservice.app.dto

import ni.bob.ant.orderservice.app.data.model.OrderItemModel
import ni.bob.ant.orderservice.app.data.model.OrderModel
import ni.bob.ant.orderservice.app.data.model.StockItemModel
import ni.bob.ant.orderservice.core.entity.*
import ni.bob.ant.orderservice.usecase.dto.OrderDto
import ni.bob.ant.orderservice.usecase.dto.OrderItemDto

class OrderItemRequest(
    val id: Long,
    val amount: Int,
    val username: String
)

data class OrderResponse(
    val id: Long,
    val state: String,
    val totalCost: Long,
    val countOfItems: Int,
    val username: String = "Username",
    val items: List<OrderItemDto>
)

fun OrderDto.toResponse() = OrderResponse(
        id = this.id,
        state = this.state,
        totalCost = this.totalCost,
        countOfItems = this.items.size,
        items = this.items
)

fun OrderModel.toEntity() = Order(
        identity = Identity(this.orderId),
        state = this.state.toState()!!,
        orderItems = this.orderItems.map { it.toEntity() }
)

private fun String.toState(): OrderState? =
        when (this.toLowerCase()) {
            "collecting" -> OrderState.Collecting
            "paid" -> OrderState.Paid
            "failed" -> OrderState.Failed
            "shipping" -> OrderState.Shipping
            "cancelled" -> OrderState.Cancelled
            "complete" -> OrderState.Completed
            else -> null
        }

fun OrderItemModel.toEntity() = OrderItem(
        identity = Identity(this.id),
        stockItem = this.stockItem.toEntity(),
        quantity = this.quantity
)

fun StockItemModel.toEntity() = StockItem(
        identity = Identity(this.id),
        name = this.name,
        price = this.price
)

fun Order.toModel() = OrderModel().apply {
    this.orderId = this@toModel.identity.value
    this.state = this@toModel.state.toString()
    this.orderItems = this@toModel.orderItems.map { it.toModel() }
    this.totalCost = this@toModel.totalCost
    this.totalAmount = this@toModel.totalAmount
}

fun OrderItem.toModel() = OrderItemModel().apply {
    this.id = this@toModel.identity.value
    this.stockItem = this@toModel.stockItem.toModel()
    this.quantity = this@toModel.quantity
}

fun StockItem.toModel() = StockItemModel().apply {
    this.id = this@toModel.identity.value
    this.name = this@toModel.name
    this.price = this@toModel.price
}
