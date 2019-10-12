package ni.bob.ant.warehouseservice.usecase.dto

import ni.bob.ant.warehouseservice.core.entity.WarehouseItem

data class WarehouseItemDto(
        val id: Long,
        val name: String,
        val quantity: Int,
        val price: Int
)

fun WarehouseItem.toDto() = WarehouseItemDto(
        id = this.identity.value,
        name = this.name,
        quantity = this.quantity,
        price = this.price
)
