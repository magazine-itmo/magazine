package ni.bob.ant.orderservice.app.controller

import ni.bob.ant.orderservice.usecase.usecase.ChangeOrderStatusUseCase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/orders")
class OrderController(
        private val changeOrderStatusUseCase: ChangeOrderStatusUseCase
) {

}
