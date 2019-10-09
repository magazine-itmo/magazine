package ni.bob.ant.warehouseservice.app.controller

import ni.bob.ant.warehouseservice.app.controller.dto.WarehouseItemRequest
import ni.bob.ant.warehouseservice.app.controller.dto.WarehouseItemResponse
import ni.bob.ant.warehouseservice.app.controller.dto.toResponse
import ni.bob.ant.warehouseservice.usecase.usecase.CreateItemUseCase
import ni.bob.ant.warehouseservice.usecase.usecase.FindWarehouseItemUseCase
import ni.bob.ant.warehouseservice.usecase.usecase.GetAllWarehouseItemsUseCase
import ni.bob.ant.warehouseservice.usecase.usecase.ReplenishItemUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/warehouse/items")
class WarehouseController(
        private val getAllWarehouseItemsUseCase: GetAllWarehouseItemsUseCase,
        private val findWarehouseItemUseCase: FindWarehouseItemUseCase,
        private val createItemUseCase: CreateItemUseCase,
        private val replenishItemUseCase: ReplenishItemUseCase
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
    ): WarehouseItemResponse = createItemUseCase.execute(
            CreateItemUseCase.NewWarehouseItemDto(request.name, request.amount, request.price)
    ).toResponse()

    @PutMapping("{itemId}/addition/{amount}")
    fun replenishItem(
            @PathVariable itemId: Long,
            @PathVariable amount: Long
    ): WarehouseItemResponse = replenishItemUseCase.execute(itemId, amount).toResponse()
}
