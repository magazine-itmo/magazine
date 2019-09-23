package ni.bob.ant.warehouseservice.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WarehouseServiceApplication

fun main(args: Array<String>) {
    runApplication<WarehouseServiceApplication>(*args)
}
