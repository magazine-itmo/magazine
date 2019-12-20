package ni.bob.ant.paymentservice.api.dto

data class PerformPaymentRequest(
        val orderId: Long,
        val totalCost: Long
)

data class PerformPaymentResponse(
        val isSuccess: Boolean
)