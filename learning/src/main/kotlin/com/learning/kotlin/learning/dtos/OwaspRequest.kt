package com.learning.kotlin.learning.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class OwaspRequest(
    @field:NotBlank val name:String, @field:NotNull var year:String, @field:NotBlank val description:String)
