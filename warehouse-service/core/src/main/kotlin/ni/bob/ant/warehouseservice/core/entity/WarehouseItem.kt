package ni.bob.ant.warehouseservice.core.entity

class WarehouseItem(
        val item: Item,
        amount: Long
) {

    var amount: Long = amount
        private set

    fun replenish(amount: Long) {
        this.amount += amount
    }
}
