package ni.bob.ant.orderservice.app.data.repository

import ni.bob.ant.orderservice.app.data.model.OrderModel
import org.springframework.data.jpa.repository.JpaRepository

interface JpaOrderRepository : JpaRepository<OrderModel, Long>
