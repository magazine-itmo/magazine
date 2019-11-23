package ni.bob.ant.orderservice.app.data.model

import javax.persistence.*

@Entity
@Table(name = "order_items")
data class OrderItemModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
) {
    @ManyToOne(targetEntity = StockItemModel::class)
    lateinit var stockItem: StockItemModel

    @Column(nullable = false)
    var quantity: Int = 0
}