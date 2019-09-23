package ni.bob.ant.orderservice.core.entity

import ni.bob.ant.orderservice.core.entity.OrderState.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

internal class OrderStateTransitionsTest {

    @Test
    fun testAvailableTransitions() {
        Collecting.assertHasTransition(Paid)
        Collecting.assertHasTransition(Failed)
        Paid.assertHasTransition(Shipping)
        Paid.assertHasTransition(Cancelled)
        Shipping.assertHasTransition(Completed)
    }

    @Test
    fun testTerminalTransitions() {
        Completed.assertHasNoTransition(Shipping)
        Completed.assertHasNoTransition(Cancelled)
        Completed.assertHasNoTransition(Failed)
        Cancelled.assertHasNoTransition(Failed)
        Failed.assertHasNoTransition(Completed)
    }

    private fun OrderState.assertHasTransition(to: OrderState) = assertTransition(to, available = true)

    private fun OrderState.assertHasNoTransition(to: OrderState) = assertTransition(to, available = false)

    private fun OrderState.assertTransition(to: OrderState, available: Boolean) {
        assertThat(
                OrderStateTransitions.isTransitionAllowed(this, to),
                `is`(available)
        )
    }
}
