package ni.bob.ant.orderservice.core.entity

import java.util.*

class Order(
    val identity: Identity,
    state: OrderState,
    orderItems: List<OrderItem> = emptyList()
) {

    var state: OrderState = state
        private set

    val totalCost: Long
        get() = orderItems.map { it.quantity * it.stockItem.price }.sum().toLong()

    val totalAmount: Int
        get() = orderItems.map { it.quantity }.sum()

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

    fun addItems(stockItem: StockItem, quantity: Int) {
        val orderItem = _orderItems.find { it.stockItem == stockItem }
                ?.let { orderItem ->
                    orderItem.copy(quantity = orderItem.quantity + quantity)
                }
                ?: OrderItem(Identity.new, stockItem, quantity)
        _orderItems.add(orderItem)
    }
}
