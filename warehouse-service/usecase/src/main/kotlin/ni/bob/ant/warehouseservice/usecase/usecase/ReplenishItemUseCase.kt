package ni.bob.ant.warehouseservice.usecase.usecase

import ni.bob.ant.warehouseservice.core.entity.Identity
import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import ni.bob.ant.warehouseservice.usecase.conf.UseCase
import ni.bob.ant.warehouseservice.usecase.dto.WarehouseItemDto
import ni.bob.ant.warehouseservice.usecase.dto.toDto
import ni.bob.ant.warehouseservice.usecase.usecase.exceptions.IllegalAmountException
import ni.bob.ant.warehouseservice.usecase.usecase.exceptions.notFound

@UseCase
class ReplenishItemUseCase(
        private val warehouseRepository: WarehouseRepository
) {

    fun execute(itemId: Long, amount: Long): WarehouseItemDto {
        amount.takeIf { it < 0 || it > 10_000 }?.let { throw IllegalAmountException(amount) }
        val itemQuantity = warehouseRepository.findByItemId(Identity(itemId)) ?: notFound<WarehouseItem>(itemId)
        itemQuantity.replenish(amount)
        warehouseRepository.save(itemQuantity)
        return itemQuantity.toDto()
    }

    interface WarehouseRepository {
        fun findByItemId(identity: Identity): WarehouseItem?
        fun save(item: WarehouseItem)
    }
}
