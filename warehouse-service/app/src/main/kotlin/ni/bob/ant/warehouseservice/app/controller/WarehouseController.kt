package ni.bob.ant.warehouseservice.app.controller

import ni.bob.ant.warehouseservice.api.dto.ReserveWarehouseItemRequest
import ni.bob.ant.warehouseservice.api.dto.ReserveWarehouseItemResponse
import ni.bob.ant.warehouseservice.app.controller.dto.WarehouseItemRequest
import ni.bob.ant.warehouseservice.app.controller.dto.WarehouseItemResponse
import ni.bob.ant.warehouseservice.app.controller.dto.toResponse
import ni.bob.ant.warehouseservice.usecase.usecase.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/warehouse/items")
class WarehouseController(
    private val getAllWarehouseItemsUseCase: GetAllWarehouseItemsUseCase,
    private val findWarehouseItemUseCase: FindWarehouseItemUseCase,
    private val createWarehouseItemUseCase: CreateWarehouseItemUseCase,
    private val replenishItemUseCase: ReplenishItemUseCase,
    private val reservationItemUseCase: ReservationItemUseCase
) {

    @GetMapping
    fun getAllItems(): List<WarehouseItemResponse> = getAllWarehouseItemsUseCase.execute().map { it.toResponse() }

    @GetMapping("{itemId}")
    fun getItemById(
        @PathVariable itemId: Long
    ): WarehouseItemResponse = findWarehouseItemUseCase.execute(itemId).toResponse()

    @PostMapping
    fun createItem(
        @RequestBody request: WarehouseItemRequest
    ): WarehouseItemResponse = createWarehouseItemUseCase.execute(
            CreateWarehouseItemUseCase.NewWarehouseItemDto(request.name, request.quantity, request.price)
    ).toResponse()

    @PutMapping("{itemId}")
    fun replenishItem(
        @RequestBody request: WarehouseItemRequest,
        @PathVariable itemId: Long
    ): WarehouseItemResponse =
            replenishItemUseCase.execute(itemId, request.quantity).toResponse()

    @PostMapping("/reservation")
    fun reserveItems(
        @RequestBody request: ReserveWarehouseItemRequest
    ): ReserveWarehouseItemResponse =
            reservationItemUseCase.execute(request.itemId, request.quantity).toResponse()
}
