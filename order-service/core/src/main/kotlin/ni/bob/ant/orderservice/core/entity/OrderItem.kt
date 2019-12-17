package ni.bob.ant.orderservice.core.entity

data class OrderItem(
    var identity: Identity,
    val stockItem: StockItem,
    var quantity: Int
) {
    fun replenish(quantity: Int) {
        assert(quantity > 0)
        this.quantity += quantity
    }
}
