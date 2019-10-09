package ni.bob.ant.orderservice.core.entity

sealed class OrderState {
    object Collecting : OrderState()
    object Paid : OrderState()
    object Failed : OrderState()
    object Shipping : OrderState()
    object Cancelled : OrderState()
    object Completed : OrderState()
}
