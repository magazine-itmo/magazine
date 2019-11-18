package ni.bob.ant.orderservice.core.entity

data class OrderItem(
        var identity: Identity,
        val stockItem: StockItem,
        val quantity: Int
)
