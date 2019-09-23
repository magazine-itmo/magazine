package ni.bob.ant.warehouseservice.app.controller.dto

import ni.bob.ant.warehouseservice.usecase.dto.WarehouseItemDto


data class CatalogItemRequest(
        val name: String,
        val amount: Long
)

data class CatalogItemResponse(
        val id: Long,
        val name: String,
        val amount: Long
)

fun WarehouseItemDto.toResponse() = CatalogItemResponse(
        id = this.itemDto.id,
        name = this.itemDto.name,
        amount = this.amount
)
