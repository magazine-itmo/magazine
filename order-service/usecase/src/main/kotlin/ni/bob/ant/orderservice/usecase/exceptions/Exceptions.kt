package ni.bob.ant.orderservice.usecase.exceptions

open class NotFoundException(id: Any, entity: String) : RuntimeException("$entity with identifier $id not found")

inline fun <reified T : Any> notFound(id: Any): Nothing = throw NotFoundException(id, T::class.java.simpleName)

class TransitionIsNotAllowed(id: Any, state: String)
    : RuntimeException("Transition to state $state is not allowed for order $id")

class IllegalAmountException(amount: Long) : RuntimeException("Cannot replenish item with $amount")
