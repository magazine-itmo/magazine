package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.dto.toEntity
import ni.bob.ant.orderservice.app.dto.toModel
import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.Order
import ni.bob.ant.orderservice.usecase.gateway.OrderRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl(private val jpaRepository: JpaOrderRepository) : OrderRepository {

    override fun create(newOrder: Order): Order {
        require(newOrder.identity == Identity.new) { "New newOrder is expected $newOrder" }
        return jpaRepository.save(newOrder.toModel()).toEntity()
    }

    override fun save(order: Order): Order {
        return jpaRepository.save(order.toModel()).toEntity()
    }

    override fun findAll(): List<Order> {
        return jpaRepository.findAll().map { it.toEntity() }
    }

    override fun findOrderById(identity: Identity): Order? {
        return jpaRepository.findByIdOrNull(identity.value)?.toEntity()
    }
}
