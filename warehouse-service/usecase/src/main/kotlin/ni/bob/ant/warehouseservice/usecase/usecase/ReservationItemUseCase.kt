package ni.bob.ant.warehouseservice.usecase.usecase

import ni.bob.ant.warehouseservice.core.entity.Identity
import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import ni.bob.ant.warehouseservice.usecase.conf.UseCase
import ni.bob.ant.warehouseservice.usecase.dto.WarehouseReserveItemDto
import ni.bob.ant.warehouseservice.usecase.usecase.exceptions.notFound

@UseCase
class ReservationItemUseCase(
        val reservationRepository: ReservationRepository
) {
    fun execute(itemId: Long, toReserve: Int): WarehouseReserveItemDto {
        val item = reservationRepository.findByItemId(Identity(itemId)) ?: notFound<WarehouseItem>(itemId)
        val quantity = item.quantity
        val result = WarehouseReserveItemDto(itemId, item.name, toReserve, item.price)
        if (toReserve <= quantity) {
            item.reserve(toReserve)
            result.enoughToReserve = true
        }
        reservationRepository.save(item)
        return result
    }

    interface ReservationRepository {
        fun findByItemId(identity: Identity): WarehouseItem?
        fun save(item: WarehouseItem)
    }
}
