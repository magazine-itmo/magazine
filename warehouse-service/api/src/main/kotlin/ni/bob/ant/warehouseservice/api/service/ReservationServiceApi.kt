package ni.bob.ant.warehouseservice.api.service

import ni.bob.ant.warehouseservice.api.dto.ReserveWarehouseItemRequest
import ni.bob.ant.warehouseservice.api.dto.ReserveWarehouseItemResponse

interface ReservationServiceApi {
    fun reserveItems(request: ReserveWarehouseItemRequest): ReserveWarehouseItemResponse
}