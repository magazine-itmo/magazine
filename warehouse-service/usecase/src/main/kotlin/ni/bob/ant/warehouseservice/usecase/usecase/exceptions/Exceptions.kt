package ni.bob.ant.warehouseservice.usecase.usecase.exceptions

open class NotFoundException(id: Any, entity: String) : RuntimeException("$entity with identifier $id not found")

inline fun <reified T : Any> notFound(id: Any): Nothing = throw NotFoundException(id, T::class.java.simpleName)

class IllegalAmountException(amount: Int) : RuntimeException("Cannot replenish item with $amount")
