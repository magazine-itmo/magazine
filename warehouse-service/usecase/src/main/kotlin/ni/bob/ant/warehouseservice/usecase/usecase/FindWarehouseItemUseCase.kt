package ni.bob.ant.warehouseservice.usecase.usecase

import ni.bob.ant.warehouseservice.core.entity.Identity
import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import ni.bob.ant.warehouseservice.usecase.conf.UseCase
import ni.bob.ant.warehouseservice.usecase.dto.WarehouseItemDto
import ni.bob.ant.warehouseservice.usecase.dto.toDto
import ni.bob.ant.warehouseservice.usecase.usecase.exceptions.notFound

@UseCase
class FindWarehouseItemUseCase(
    private val warehouseRepository: WarehouseRepository
) {

    fun execute(id: Long): WarehouseItemDto {
        return warehouseRepository.findByItemId(Identity(id))?.toDto() ?: notFound<WarehouseItem>(id)
    }

    interface WarehouseRepository {
        fun findByItemId(identity: Identity): WarehouseItem?
    }
}
