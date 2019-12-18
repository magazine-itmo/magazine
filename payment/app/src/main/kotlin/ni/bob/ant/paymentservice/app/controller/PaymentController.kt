package ni.bob.ant.paymentservice.app.controller

import ni.bob.ant.paymentservice.app.controller.dto.PaymentRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/payment/pay")
class PaymentController {

    @GetMapping
    fun performPayment(request: PaymentRequest): String = "oplacheno, molodec"
}
