package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.data.model.OrderItemModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface JpaOrderItemRepository : JpaRepository<OrderItemModel, Long> {

    @Query("SELECT oim FROM OrderModel o INNER JOIN OrderItemModel oim WHERE o.orderId = :orderId AND oim.stockItem = :stockItemId")
    fun findByStockItemId(orderId: Long, @Param("stockItemId") stockItemId: Long): OrderItemModel?
}
