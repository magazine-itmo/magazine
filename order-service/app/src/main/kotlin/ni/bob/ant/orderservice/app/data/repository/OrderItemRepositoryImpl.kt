package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.dto.toEntity
import ni.bob.ant.orderservice.app.dto.toModel
import ni.bob.ant.orderservice.core.entity.Identity
import ni.bob.ant.orderservice.core.entity.OrderItem
import ni.bob.ant.orderservice.usecase.usecase.AddOrderItemUseCase
import org.springframework.stereotype.Repository

@Repository
class OrderItemRepositoryImpl(
        private val jpaRepository: JpaOrderItemRepository
) : AddOrderItemUseCase.OrderItemRepository {

    override fun findByStockItemId(stockItemId: Identity): List<OrderItem> {
        return jpaRepository.findByStockItemId(stockItemId.value).map { it.toEntity() }
    }

    override fun save(orderItem: OrderItem): OrderItem {
        return jpaRepository.save(orderItem.toModel()).toEntity()
    }
}