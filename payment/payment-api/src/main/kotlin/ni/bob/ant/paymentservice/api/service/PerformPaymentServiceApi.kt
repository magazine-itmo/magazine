package ni.bob.ant.paymentservice.api.service

import ni.bob.ant.paymentservice.api.dto.PerformPaymentRequest
import ni.bob.ant.paymentservice.api.dto.PerformPaymentResponse

interface PerformPaymentServiceApi {
    fun performPayment(request: PerformPaymentRequest): PerformPaymentResponse
}