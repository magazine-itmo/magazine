package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.data.model.OrderItemModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface JpaOrderItemRepository : JpaRepository<OrderItemModel, Long> {

    @Query("SELECT oim FROM OrderModel o INNER JOIN OrderItemModel oim WHERE o.orderId = :orderId AND oim.stockItem = :stockItem")
    fun findByStockItemId(orderId: Long, stockItemId: Long): OrderItemModel?
}
