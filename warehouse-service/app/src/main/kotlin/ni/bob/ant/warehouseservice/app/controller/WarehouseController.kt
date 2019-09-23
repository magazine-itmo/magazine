package ni.bob.ant.warehouseservice.app.controller

import ni.bob.ant.warehouseservice.app.controller.dto.CatalogItemRequest
import ni.bob.ant.warehouseservice.app.controller.dto.CatalogItemResponse
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
    fun getAllItems(): List<CatalogItemResponse> = getAllWarehouseItemsUseCase.execute().map { it.toResponse() }

    @GetMapping("{itemId}")
    fun getItemById(
            @PathVariable itemId: Long
    ): CatalogItemResponse = findWarehouseItemUseCase.execute(itemId).toResponse()

    @PostMapping
    fun createItem(
            @RequestBody request: CatalogItemRequest
    ): CatalogItemResponse = createItemUseCase.execute(request.name, request.amount).toResponse()

    @PutMapping("{itemId}/addition/{amount}")
    fun replenishItem(
            @PathVariable itemId: Long,
            @PathVariable amount: Long
    ): CatalogItemResponse = replenishItemUseCase.execute(itemId, amount).toResponse()
}
