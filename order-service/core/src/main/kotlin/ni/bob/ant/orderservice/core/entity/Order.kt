package ni.bob.ant.orderservice.core.entity

import java.util.*

class Order(
    val identity: Identity,
    state: OrderState,
    orderItems: List<OrderItem>
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

    fun addItems(orderItem: OrderItem, quantity: Int): OrderItem {
        val storedItem = _orderItems.find { it == orderItem }
                ?.let { existingItem ->
                    existingItem.copy(quantity = existingItem.quantity + quantity)
                }
                ?: orderItem
        _orderItems.add(storedItem)
        return storedItem
    }
}
