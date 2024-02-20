package com.kappann.kotlin.stock.errors.handlers

import jakarta.validation.ConstraintViolationException
import lombok.extern.slf4j.Slf4j
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@Slf4j
@ControllerAdvice
@RestController
class ApiExceptionsHandler {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException::class)
    private fun handleConstraintViolation(ex: ConstraintViolationException): ErrorResponse {
        log.debug(
            "Constraint violation exception encountered: {}",
            ex.constraintViolations,
            ex
        )
        var message: String = "Error(s): /n"
        ex.constraintViolations.forEach {
            message += (it.message.plus(" /n"))
        }
        return ErrorResponse(message)
    }

}