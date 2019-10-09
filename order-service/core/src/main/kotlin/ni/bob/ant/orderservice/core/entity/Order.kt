package ni.bob.ant.orderservice.core.entity

import java.util.*

class Order(
        val identity: Identity,
        state: OrderState,
        orderItems: List<OrderItem>
) {

    var state: OrderState = state
        private set

    val totalAmount: Long
        get() = orderItems.map { it.quantity * it.stockItem.price }.sum()

    private val _orderItems: MutableCollection<OrderItem> = TreeSet<OrderItem>(
            Comparator.comparingLong { it.stockItem.identity.value }
    ).apply { addAll(orderItems) }
    val orderItems: Collection<OrderItem>
        get() = _orderItems

    fun toState(newState: OrderState) {
        state = newState
    }

    fun isTransitionAllowed(newState: OrderState): Boolean {
        return OrderStateTransitions.isTransitionAllowed(state, newState)
    }

    fun addItems(stockItem: StockItem, quantity: Long) {
        val orderItem = _orderItems.find { it.stockItem == stockItem }
                ?.let { orderItem ->
                    orderItem.copy(quantity = orderItem.quantity + quantity)
                }
                ?: OrderItem(Identity.new, stockItem, quantity)
        _orderItems.add(orderItem)
    }
}
