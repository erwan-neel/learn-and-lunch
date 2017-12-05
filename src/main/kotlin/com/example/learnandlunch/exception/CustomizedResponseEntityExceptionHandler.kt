package com.example.learnandlunch.exception

import com.example.learnandlunch.user.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class CustomizedResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<Error> {
        val error = Error(Date(), ex.message, request.getDescription(false))
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }
}