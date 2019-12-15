package ni.bob.ant.warehouseservice.app.controller.dto

import ni.bob.ant.warehouseservice.api.dto.ReserveWarehouseItemResponse
import ni.bob.ant.warehouseservice.usecase.dto.WarehouseItemDto
import ni.bob.ant.warehouseservice.usecase.dto.WarehouseReserveItemDto


data class WarehouseItemRequest(
    val name: String,
    val quantity: Int,
    val price: Int
)

data class WarehouseItemResponse(
    val id: Long,
    val name: String,
    val quantity: Int,
    val price: Int
)

fun WarehouseItemDto.toResponse() = WarehouseItemResponse(
        id = this.id,
        name = this.name,
        quantity = this.quantity,
        price = this.price
)


fun WarehouseReserveItemDto.toResponse() = ReserveWarehouseItemResponse(
        itemId = this.id,
        name = this.name,
        quantity = this.quantity,
        price = this.price,
        reserved = this.enoughToReserve
)
