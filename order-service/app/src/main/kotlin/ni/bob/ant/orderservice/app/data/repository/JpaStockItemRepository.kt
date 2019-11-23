package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.data.model.StockItemModel
import org.springframework.data.jpa.repository.JpaRepository

interface JpaStockItemRepository : JpaRepository<StockItemModel, Long>
