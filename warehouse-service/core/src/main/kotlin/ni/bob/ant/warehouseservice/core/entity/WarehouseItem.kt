package ni.bob.ant.warehouseservice.core.entity

class WarehouseItem(
    val identity: Identity,
    val name: String,
    val price: Int,
    quantity: Int
) {

    var quantity: Int = quantity
        private set

    fun replenish(quantity: Int) {
        this.quantity += quantity
    }
}
