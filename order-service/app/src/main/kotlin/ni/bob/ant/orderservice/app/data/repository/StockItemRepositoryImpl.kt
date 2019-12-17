package ni.bob.ant.orderservice.app.data.repository

import feign.FeignException
import ni.bob.ant.orderservice.app.dto.toEntity
import ni.bob.ant.orderservice.app.dto.toModel
import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.StockItem
import ni.bob.ant.orderservice.usecase.exceptions.notFound
import ni.bob.ant.orderservice.usecase.gateway.StockItemRepository
import ni.bob.ant.warehouseservice.api.dto.ReserveWarehouseItemRequest
import ni.bob.ant.warehouseservice.api.dto.ReserveWarehouseItemResponse
import ni.bob.ant.warehouseservice.api.feign.ReservationServiceClient
import org.springframework.stereotype.Repository

@Repository
class StockItemRepositoryImpl(
    private val jpaRepository: JpaStockItemRepository,
    private val reservationServiceClient: ReservationServiceClient
) : StockItemRepository {

    override fun reserveItemIfExists(identity: Identity, quantity: Int): StockItem? {
        val response: ReserveWarehouseItemResponse
        try {
            response = reservationServiceClient.reserveItems(ReserveWarehouseItemRequest(identity.value, quantity))
        } catch (e: FeignException) {
            return null
        }
        if (!response.reserved)
            //FIXME Поправти пожалусто
            throw RuntimeException("Not enough items quantity in database")
        return StockItem(Identity(response.itemId), response.name, response.price)

    }

    override fun save(item: StockItem): StockItem {
        return jpaRepository.save(item.toModel()).toEntity()
    }
}
