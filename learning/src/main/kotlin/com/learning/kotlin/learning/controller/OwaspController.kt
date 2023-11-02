package com.learning.kotlin.learning.controller

import com.learning.kotlin.learning.dtos.OwaspRequest
import com.learning.kotlin.learning.service.OwaspService
import com.learning.kotlin.learning.dtos.OwaspResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/owasp")
@Validated
class OwaspController(private val owaspService: OwaspService) {


    @GetMapping("all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun getAllOwaspSecurityRisks():   List<OwaspResponse> {
        return owaspService.getOwaspSecurityRisk()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOwaspRecord(@Valid @RequestBody owaspRequest: OwaspRequest) :OwaspResponse{
        return owaspService.createOwasp(owaspRequest);
    }

    //todo: implement other endpoints like put, delete and view
    //todo: handle 405, 401 and 403, 404, 415
}