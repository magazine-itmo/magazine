package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.dto.toEntity
import ni.bob.ant.orderservice.app.dto.toModel
import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.OrderItem
import ni.bob.ant.orderservice.usecase.gateway.OrderItemRepository
import org.springframework.stereotype.Repository

@Repository
class OrderItemRepositoryImpl(
    private val jpaRepository: JpaOrderItemRepository
) : OrderItemRepository {

    override fun findByStockItemId(orderId: Long, stockItemId: Identity): OrderItem? {
        return jpaRepository.findByStockItemId(orderId, stockItemId.value)?.toEntity()
    }

    override fun save(orderItem: OrderItem): OrderItem {
        return jpaRepository.save(orderItem.toModel()).toEntity()
    }
}