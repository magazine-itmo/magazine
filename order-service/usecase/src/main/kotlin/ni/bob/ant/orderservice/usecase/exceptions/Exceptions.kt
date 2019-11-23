package ni.bob.ant.orderservice.usecase.exceptions

import ni.bob.ant.orderservice.core.entity.OrderState

open class NotFoundException(id: Any, entity: String) : RuntimeException("$entity with identifier $id not found")

inline fun <reified T : Any> notFound(id: Any): Nothing = throw NotFoundException(id, T::class.java.simpleName)

class TransitionIsNotAllowed(orderId: Any, prevState: OrderState, newState: OrderState)
    : RuntimeException("Transition $prevState => $newState is not allowed for order $orderId")
