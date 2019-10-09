package ni.bob.ant.orderservice.core.entity

data class OrderItem(
        val identity: Identity,
        val stockItem: StockItem,
        val quantity: Long
)
