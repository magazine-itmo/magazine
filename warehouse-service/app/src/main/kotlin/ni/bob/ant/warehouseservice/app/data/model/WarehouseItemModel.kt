package ni.bob.ant.warehouseservice.app.data.model

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
    var price: Long = 0

    @Column(nullable = false)
    var amount: Long = 0
}
