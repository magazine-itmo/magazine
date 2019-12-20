package ni.bob.ant.orderservice.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["ni.bob.ant.orderservice.usecase.usecase", "ni.bob.ant.orderservice.app"])
@EnableFeignClients(basePackages = ["ni.bob.ant.warehouseservice.api", "ni.bob.ant.paymentservice.api"])
@SpringBootApplication
class OrderServiceApplication

fun main(args: Array<String>) {
    runApplication<OrderServiceApplication>(*args)
}
