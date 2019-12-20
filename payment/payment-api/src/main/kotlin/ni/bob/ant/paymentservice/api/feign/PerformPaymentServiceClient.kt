package ni.bob.ant.paymentservice.api.feign

import ni.bob.ant.paymentservice.api.dto.PerformPaymentRequest
import ni.bob.ant.paymentservice.api.dto.PerformPaymentResponse
import ni.bob.ant.paymentservice.api.service.PerformPaymentServiceApi
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PutMapping

@Component
@FeignClient(name = "payment-service", url = "http://localhost:8037/api/payment/pay")
interface PerformPaymentServiceClient : PerformPaymentServiceApi {

    @PutMapping
    override fun performPayment(request: PerformPaymentRequest): PerformPaymentResponse
}