package ni.bob.ant.warehouseservice.api.feign

import ni.bob.ant.warehouseservice.api.dto.ReserveWarehouseItemRequest
import ni.bob.ant.warehouseservice.api.dto.ReserveWarehouseItemResponse
import ni.bob.ant.warehouseservice.api.service.ReservationServiceApi
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping

@Component
@FeignClient(name = "warehouse-service", url = "http://localhost:8437/api/warehouse/items/reservation")
interface ReservationServiceClient : ReservationServiceApi {

    @PostMapping
    override fun reserveItems(request: ReserveWarehouseItemRequest): ReserveWarehouseItemResponse
}