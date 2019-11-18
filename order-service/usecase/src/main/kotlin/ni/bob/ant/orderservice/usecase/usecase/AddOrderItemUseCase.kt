package ni.bob.ant.orderservice.usecase.usecase

import ni.bob.ant.orderservice.core.entity.*
import ni.bob.ant.orderservice.usecase.conf.UseCase
import ni.bob.ant.orderservice.usecase.dto.ItemDto
import ni.bob.ant.orderservice.usecase.exceptions.notFound

@UseCase
class AddOrderItemUseCase(
        private val orderRepository: OrderRepository,
        private val orderItemRepository: OrderItemRepository,
        private val stockItemRepository: StockItemRepository
) {
    fun execute(id: Long, item: ItemDto): Long {
        //TODO: Implement the ability to find item by id in WarehouseService
        //At this moment "Mock" is used
        var stockItem = StockItem(Identity(item.id), "MockItem", -1)
        stockItem = stockItemRepository.save(stockItem)
        var newOrderItem = OrderItem(Identity.new, stockItem, item.amount)
        if (id == -1L) {
            newOrderItem = orderItemRepository.save(newOrderItem)
            val order = Order(Identity.new, OrderState.Collecting, listOf(newOrderItem))
            return orderRepository.create(order).identity.value
        }
        val order = orderRepository.findOrderById(Identity(id)) ?: notFound<Order>(id)
        val list = orderItemRepository.findByStockItemId(stockItem.identity)
        val intersect = order.orderItems.intersect(list)
        val orderItem = if (intersect.isNotEmpty()) intersect.iterator().next() else orderItemRepository.save(newOrderItem)
        orderItemRepository.save(order.addItems(orderItem, item.amount))
        return orderRepository.save(order).identity.value
    }

    interface OrderRepository {
        fun findOrderById(identity: Identity): Order?
        fun save(order: Order): Order
        fun create(newOrder: Order): Order
    }

    interface OrderItemRepository {
        fun save(orderItem: OrderItem): OrderItem
        fun findByStockItemId(stockItemId: Identity): List<OrderItem>
    }

    interface StockItemRepository {
        fun save(item: StockItem): StockItem
    }
}
