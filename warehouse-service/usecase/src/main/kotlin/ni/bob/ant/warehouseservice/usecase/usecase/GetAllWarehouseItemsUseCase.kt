package ni.bob.ant.warehouseservice.usecase.usecase

import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import ni.bob.ant.warehouseservice.usecase.conf.UseCase
import ni.bob.ant.warehouseservice.usecase.dto.WarehouseItemDto
import ni.bob.ant.warehouseservice.usecase.dto.toDto

@UseCase
class GetAllWarehouseItemsUseCase(
    private val warehouseRepository: WarehouseRepository
) {

    fun execute(): List<WarehouseItemDto> {
        return warehouseRepository.findAll().map { it.toDto() }
    }

    interface WarehouseRepository {
        fun findAll(): List<WarehouseItem>
    }
}
