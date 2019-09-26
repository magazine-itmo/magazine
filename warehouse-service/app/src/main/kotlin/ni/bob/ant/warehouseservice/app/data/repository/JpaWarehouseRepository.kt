package ni.bob.ant.warehouseservice.app.data.repository

import ni.bob.ant.warehouseservice.app.data.model.WarehouseItemModel
import org.springframework.data.jpa.repository.JpaRepository

interface JpaWarehouseRepository : JpaRepository<WarehouseItemModel, Long>