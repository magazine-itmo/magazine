package ni.bob.ant.warehouseservice.core.entity

class WarehouseItem(
        val identity: Identity,
        val name: String,
        quantity: Long
) {

    var quantity: Long = quantity
        private set

    fun replenish(amount: Long) {
        this.quantity += amount
    }
}
