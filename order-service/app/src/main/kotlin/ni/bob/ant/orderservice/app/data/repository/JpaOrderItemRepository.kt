package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.data.model.OrderItemModel
import org.springframework.data.jpa.repository.JpaRepository

interface JpaOrderItemRepository : JpaRepository<OrderItemModel, Long> {
    fun findByStockItemId(stockItemId: Long): List<OrderItemModel>
}