package ni.bob.ant.warehouseservice.usecase.dto

import ni.bob.ant.warehouseservice.core.entity.WarehouseItem

data class WarehouseItemDto(
        val itemDto: ItemDto,
        val amount: Long
)

fun WarehouseItem.toDto() = WarehouseItemDto(
        itemDto = this.item.toDto(),
        amount = this.amount
)
