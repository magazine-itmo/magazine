package ni.bob.ant.warehouseservice.app.controller.dto

import ni.bob.ant.warehouseservice.usecase.dto.WarehouseItemDto


data class WarehouseItemRequest(
        val name: String,
        val amount: Long
)

data class WarehouseItemResponse(
        val id: Long,
        val name: String,
        val amount: Long
)

fun WarehouseItemDto.toResponse() = WarehouseItemResponse(
        id = this.id,
        name = this.name,
        amount = this.amount
)
