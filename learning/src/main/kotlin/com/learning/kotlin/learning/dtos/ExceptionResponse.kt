package com.learning.kotlin.learning.dtos

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import java.time.Instant

@JsonInclude(Include.NON_NULL)
data class ExceptionResponse(val message: String, val errors:List<FieldErrorResponse>?=null,  val time: Instant)
