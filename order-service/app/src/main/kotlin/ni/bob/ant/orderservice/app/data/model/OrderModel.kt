package ni.bob.ant.orderservice.app.data.model

import javax.persistence.*

@Entity
@Table(name = "orders")
data class OrderModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var orderId: Long = 0
) {
    @OneToMany
    @JoinColumn(name = "order_id")
    lateinit var orderItems: Collection<OrderItemModel>

    @Column(nullable = false)
    lateinit var state: String

    @Column(name = "total_cost", nullable = false)
    var totalCost: Long = 0

    @Column(name = "total_amount", nullable = false)
    var totalAmount: Int = 0
}
