package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.Order
import ni.bob.ant.orderservice.usecase.gateway.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrdersRepositoryImpl : OrderRepository {

    override fun findOrderById(identity: Identity): Order? {
        return TODO()
    }
}