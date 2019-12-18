package ni.bob.ant.paymentservice.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

//@ComponentScan(basePackages = ["ni.bob.ant.paymentservice.usecase.usecase", "ni.bob.ant.warehouseservice.app"])
@SpringBootApplication
class PaymentServiceApplication

fun main(args: Array<String>) {
    runApplication<PaymentServiceApplication>(*args)
}
