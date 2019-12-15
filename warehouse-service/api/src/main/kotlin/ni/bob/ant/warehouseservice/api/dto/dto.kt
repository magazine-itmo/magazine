package ni.bob.ant.warehouseservice.api.dto

data class ReserveWarehouseItemRequest(
        val itemId: Long,
        val quantity: Int
)

data class ReserveWarehouseItemResponse(
        val itemId: Long,
        val quantity: Int,
        val price: Int,
        val name: String,
        val reserved: Boolean
)