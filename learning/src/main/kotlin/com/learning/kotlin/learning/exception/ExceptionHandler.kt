package com.learning.kotlin.learning.exception

import com.learning.kotlin.learning.dtos.ExceptionResponse
import com.learning.kotlin.learning.dtos.FieldErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception
import java.time.Instant

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleGeneralException(exception: Exception) : ExceptionResponse {
        return ExceptionResponse("Some exception happened", time = Instant.now())
    }

    @ExceptionHandler(OwaspServiceException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleOwaspCustomException(exception: OwaspServiceException) : ExceptionResponse {
        return ExceptionResponse(exception.message, time=Instant.now())
    }

    @ExceptionHandler(BindException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleOwaspHttpMessageNotReadableException(exception: BindException) : ExceptionResponse {
        return ExceptionResponse("Invalid request input",  exception.fieldErrors.map { FieldErrorResponse(it.field, it.defaultMessage!!) },  Instant.now())
    }
}