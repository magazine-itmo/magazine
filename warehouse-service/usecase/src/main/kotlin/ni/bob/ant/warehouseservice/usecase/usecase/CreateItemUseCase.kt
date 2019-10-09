package ni.bob.ant.warehouseservice.usecase.usecase

import ni.bob.ant.warehouseservice.core.entity.Identity
import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import ni.bob.ant.warehouseservice.usecase.conf.UseCase
import ni.bob.ant.warehouseservice.usecase.dto.WarehouseItemDto
import ni.bob.ant.warehouseservice.usecase.dto.toDto

@UseCase
class CreateItemUseCase(
        private val warehouseRepository: WarehouseRepository
) {

    fun execute(newWarehouseItemDto: NewWarehouseItemDto): WarehouseItemDto {
        val newWarehouseItem = WarehouseItem(
                Identity.new,
                newWarehouseItemDto.name,
                newWarehouseItemDto.price,
                newWarehouseItemDto.amount
        )
        return warehouseRepository.create(newWarehouseItem).toDto()
    }

    data class NewWarehouseItemDto(
            val name: String,
            val amount: Long,
            val price: Int
    )

    interface WarehouseRepository {
        fun create(newWarehouseItem: WarehouseItem): WarehouseItem
    }
}
