package ni.bob.ant.orderservice.app.exception

import ni.bob.ant.orderservice.usecase.exceptions.NotFoundException
import org.postgresql.util.PSQLException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class RestResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [NotFoundException::class])
    fun handleException(ex: RuntimeException, webRequest: WebRequest): ResponseEntity<Any> {
        val message = Date().toString() + '\n' + ex.message
        return handleExceptionInternal(ex, message, HttpHeaders(), HttpStatus.NOT_FOUND, webRequest)
    }
}