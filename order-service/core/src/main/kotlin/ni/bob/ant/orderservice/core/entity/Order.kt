package ni.bob.ant.orderservice.core.entity

class Order(
        val identity: Identity,
        state: OrderState,
        orderItems: Map<Item, Long>
) {

    var state: OrderState = state
        private set

    private val _orderItems: MutableMap<Item, Long> = orderItems.toMutableMap()
    val orderItems: Map<Item, Long>
        get() = _orderItems

    fun toState(newState: OrderState) {
        state = newState
    }

    fun isTransitionAllowed(newState: OrderState): Boolean {
        return OrderStateTransitions.isTransitionAllowed(state, newState)
    }

    fun addItems(item: Item, amount: Long) {
        _orderItems.compute(item) { _, oldAmount ->
            (oldAmount ?: 0) + amount
        }
    }
}
