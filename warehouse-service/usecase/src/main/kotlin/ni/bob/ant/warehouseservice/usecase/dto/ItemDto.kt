package ni.bob.ant.warehouseservice.usecase.dto

import ni.bob.ant.warehouseservice.core.entity.Item

data class ItemDto(
        val id: Long,
        val name: String
)

fun Item.toDto() = ItemDto(
        id = this.identity.value,
        name = this.name
)
