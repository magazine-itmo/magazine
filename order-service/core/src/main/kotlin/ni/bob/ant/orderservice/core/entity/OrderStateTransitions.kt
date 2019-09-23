package ni.bob.ant.orderservice.core.entity

internal object OrderStateTransitions {

    private val transitions: Map<OrderState, Set<OrderState>>

    init {
        transitions = hashMapOf(
                OrderState.Collecting to hashSetOf(
                        OrderState.Paid,
                        OrderState.Failed
                ),
                OrderState.Paid to hashSetOf(
                        OrderState.Shipping,
                        OrderState.Cancelled
                ),
                OrderState.Shipping to hashSetOf(
                        OrderState.Completed
                )
        )
    }

    fun isTransitionAllowed(old: OrderState, new: OrderState): Boolean {
        return transitions[old]?.contains(new) ?: false
    }
}
