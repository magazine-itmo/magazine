package ni.bob.ant.warehouseservice.app.data.model

import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "items")
class WarehouseItemModel
//TODO: create the data class with required fields

fun WarehouseItemModel.toWarehouseItem() =
        WarehouseItem(
                TODO(),
                TODO()
        )