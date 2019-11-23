package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.data.model.OrderModel
import ni.bob.ant.orderservice.app.dto.toEntity
import ni.bob.ant.orderservice.app.dto.toModel
import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.Order
import ni.bob.ant.orderservice.core.entity.OrderState
import ni.bob.ant.orderservice.usecase.gateway.OrderRepository
import ni.bob.ant.orderservice.usecase.gateway.OrderStateRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl(
    private val jpaRepository: JpaOrderRepository,
    private val orderStateRepository: OrderStateRepository
) : OrderRepository {

    override fun create(newOrder: Order): Order {
        require(newOrder.identity == Identity.new) { "New newOrder is expected $newOrder" }
        return jpaRepository.save(newOrder.toModel())
                .let { createdOrder -> createdOrder.toEntity(createdOrder.findState()) }
    }

    override fun save(order: Order): Order {
        return jpaRepository.save(order.toModel())
                .let { savedOrder -> savedOrder.toEntity(savedOrder.findState()) }
    }

    override fun findAll(): List<Order> {
        return jpaRepository.findAll().map { it.toEntity(it.findState()) }
    }

    override fun findOrderById(identity: Identity): Order? {
        return jpaRepository.findByIdOrNull(identity.value)
                ?.let { foundOrder -> foundOrder.toEntity(foundOrder.findState()) }
    }

    private fun OrderModel.findState(): OrderState = orderStateRepository.findStateByName(this.state)
            ?: error("Illegal state name ${this.state}")
}
