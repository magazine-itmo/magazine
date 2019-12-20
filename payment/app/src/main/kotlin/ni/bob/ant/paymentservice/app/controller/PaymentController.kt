package ni.bob.ant.paymentservice.app.controller

import ni.bob.ant.paymentservice.api.dto.PerformPaymentRequest
import ni.bob.ant.paymentservice.api.dto.PerformPaymentResponse
import ni.bob.ant.paymentservice.usecase.usecase.PerformPaymentUseCase
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/payment")
class PaymentController(
        private val performPaymentUseCase: PerformPaymentUseCase
) {

    @PutMapping("/pay")
    fun performPayment(@RequestBody request: PerformPaymentRequest) = PerformPaymentResponse(performPaymentUseCase.execute())
}
