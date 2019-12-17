package ni.bob.ant.orderservice.usecase.usecase

import ni.bob.ant.orderservice.core.entity.*
import ni.bob.ant.orderservice.usecase.conf.UseCase
import ni.bob.ant.orderservice.usecase.dto.ItemDto
import ni.bob.ant.orderservice.usecase.dto.OrderDto
import ni.bob.ant.orderservice.usecase.dto.toDto
import ni.bob.ant.orderservice.usecase.exceptions.notFound

@UseCase
class AddOrderItemUseCase(
    private val orderRepository: OrderRepository,
    private val stockItemRepository: StockItemRepository
) {

    fun execute(orderId: Long, item: ItemDto): OrderDto {
        val stockItem = stockItemRepository.reserveItemIfExists(Identity(item.id), item.amount) ?: notFound<StockItem>(item.id)
        val order = if (orderId == Identity.new.value) {
            createNewOrder(item, stockItem)
        } else {
            addItemToExistingOrder(orderId, item, stockItem)
        }
        return order.toDto()
    }

    private fun createNewOrder(item: ItemDto, stockItem: StockItem): Order {
        val order = Order(Identity.new, OrderState.Collecting)
        order.addItems(stockItem, item.amount)
        return orderRepository.create(order)
    }

    private fun addItemToExistingOrder(orderId: Long, item: ItemDto, stockItem: StockItem): Order {
        val order = orderRepository.findOrderById(Identity(orderId)) ?: notFound<Order>(orderId)
        order.addItems(stockItem, item.amount)
        return orderRepository.save(order)
    }

    interface OrderRepository {
        fun findOrderById(identity: Identity): Order?
        fun save(order: Order): Order
        fun create(newOrder: Order): Order
    }

    interface StockItemRepository {
        fun reserveItemIfExists(identity: Identity, quantity: Int): StockItem?
        fun save(item: StockItem): StockItem
    }
}
