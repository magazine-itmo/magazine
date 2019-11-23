package ni.bob.ant.warehouseservice.app.data.model

import ni.bob.ant.warehouseservice.core.entity.Identity
import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import javax.persistence.*

@Entity
@Table(name = "items")
data class WarehouseItemModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
) {

    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = false)
    var price: Int = 0

    @Column(nullable = false)
    var quantity: Int = 0
}

fun WarehouseItemModel.toEntity() = WarehouseItem(
        identity = Identity(this.id),
        name = this.name,
        price = this.price,
        quantity = this.quantity
)

fun WarehouseItem.toModel() = WarehouseItemModel().apply {
    this.id = this@toModel.identity.value
    this.name = this@toModel.name
    this.price = this@toModel.price
    this.quantity = this@toModel.quantity
}