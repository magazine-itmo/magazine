package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.core.entity.OrderState
import ni.bob.ant.orderservice.usecase.gateway.OrderStateRepository
import org.springframework.stereotype.Repository

@Repository
class OrderStateRepositoryImpl : OrderStateRepository {

    override fun findStateByName(status: String): OrderState? = when (status.toLowerCase()) {
        "collecting" -> OrderState.Collecting
        "paid" -> OrderState.Paid
        "failed" -> OrderState.Failed
        "shipping" -> OrderState.Shipping
        "cancelled" -> OrderState.Cancelled
        "complete" -> OrderState.Completed
        else -> null
    }
}
