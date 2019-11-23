package ni.bob.ant.orderservice.core.entity

sealed class OrderState {
    object Collecting : OrderState()
    object Paid : OrderState()
    object Failed : OrderState()
    object Shipping : OrderState()
    object Cancelled : OrderState()
    object Completed : OrderState()

    override fun toString(): String {
        return this.javaClass.simpleName
    }
}

data class Data(
    val id: String,
    val parameterType: Parameter,
    val parameterValue: String
)

sealed class Parameter(val value: String)
object FirstName : Parameter("First Name")
object FullName : Parameter("Full Name")