package ni.bob.ant.paymentservice.usecase.usecase

import ni.bob.ant.paymentservice.usecase.conf.UseCase
import kotlin.random.Random.Default.nextBoolean

@UseCase
class PerformPaymentUseCase {
    fun execute() = nextBoolean()
}