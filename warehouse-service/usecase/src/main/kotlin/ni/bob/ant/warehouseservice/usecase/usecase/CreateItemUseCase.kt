package ni.bob.ant.warehouseservice.usecase.usecase

import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import ni.bob.ant.warehouseservice.usecase.conf.UseCase
import ni.bob.ant.warehouseservice.usecase.dto.WarehouseItemDto
import ni.bob.ant.warehouseservice.usecase.dto.toDto

@UseCase
class CreateItemUseCase(
        private val warehouseRepository: WarehouseRepository
) {

    fun execute(name: String, amount: Long): WarehouseItemDto {
        return warehouseRepository.create(name, amount).toDto()
    }

    interface WarehouseRepository {
        fun create(name: String, amount: Long): WarehouseItem
    }
}
