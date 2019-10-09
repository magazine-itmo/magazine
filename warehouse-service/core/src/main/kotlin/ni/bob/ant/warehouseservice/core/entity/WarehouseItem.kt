package ni.bob.ant.warehouseservice.core.entity

class WarehouseItem(
        val identity: Identity,
        val name: String,
        val price: Int,
        amount: Long
) {

    var amount: Long = amount
        private set

    fun replenish(amount: Long) {
        this.amount += amount
    }
}
