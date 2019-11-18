package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.dto.toEntity
import ni.bob.ant.orderservice.app.dto.toModel
import ni.bob.ant.orderservice.core.entity.StockItem
import ni.bob.ant.orderservice.usecase.usecase.AddOrderItemUseCase
import org.springframework.stereotype.Repository

@Repository
class StockItemRepositoryImpl(
        private val jpaRepository: JpaStockItemRepository
) : AddOrderItemUseCase.StockItemRepository {
    override fun save(item: StockItem): StockItem {
        return jpaRepository.save(item.toModel()).toEntity()
    }
}
