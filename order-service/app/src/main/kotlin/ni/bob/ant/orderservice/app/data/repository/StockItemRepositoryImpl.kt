package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.dto.toEntity
import ni.bob.ant.orderservice.app.dto.toModel
import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.StockItem
import ni.bob.ant.orderservice.usecase.gateway.StockItemRepository
import org.springframework.stereotype.Repository

@Repository
class StockItemRepositoryImpl(
    private val jpaRepository: JpaStockItemRepository
) : StockItemRepository {

    override fun findStockItemById(identity: Identity): StockItem? {
        // FIXME - remove stubs
        return when (identity.value.toInt()) {
            1 -> StockItem(identity, "MockIrem1", 200)
            2 -> StockItem(identity, "MockIrem2", 300)
            3 -> StockItem(identity, "MockIrem3", 400)
            else -> null
        }
    }

    override fun save(item: StockItem): StockItem {
        return jpaRepository.save(item.toModel()).toEntity()
    }
}
