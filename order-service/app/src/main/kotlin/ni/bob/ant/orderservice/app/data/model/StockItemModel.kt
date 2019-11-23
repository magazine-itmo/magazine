package ni.bob.ant.orderservice.app.data.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "stock_items")
data class StockItemModel(
    @Id
    var id: Long = 0
) {
    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = false)
    var price: Int = 0
}