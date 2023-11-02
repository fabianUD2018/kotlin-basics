package com.learning.kotlin.learning.service

import com.learning.kotlin.learning.dtos.OwaspRequest
import com.learning.kotlin.learning.repository.OwaspRepository
import com.learning.kotlin.learning.dtos.OwaspResponse
import com.learning.kotlin.learning.entities.OwaspRiskEntity
import com.learning.kotlin.learning.exception.OwaspServiceException
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.time.Instant
import java.util.UUID

@Service
class OwaspService(val owaspRepository: OwaspRepository) {


    fun getOwaspSecurityRisk(): List<OwaspResponse> {
        return owaspRepository.findAll().map(mapToOwaspResponse)
    }

    fun createOwasp(owaspRequest: OwaspRequest): OwaspResponse {
        if (owaspRepository.findByNameAndYear(owaspRequest.name, owaspRequest.year)==null) {
            return owaspRepository.save(owaspRequest.let(mapToOwaspEntity))
                .let(mapToOwaspResponse)
        } else {
            throw OwaspServiceException("Owasp top ten security already registered for this year ${owaspRequest.year}")
        }

    }


    private val mapToOwaspEntity: (OwaspRequest) -> OwaspRiskEntity = { owaspRequest ->
        OwaspRiskEntity().apply {
            id = UUID.randomUUID().toString()
            name = owaspRequest.name
            description = owaspRequest.description
            year = owaspRequest.year
            created = Instant.now()
            lastModified = Instant.now()
        }

    }

    private val mapToOwaspResponse: (OwaspRiskEntity) -> OwaspResponse = { owaspRiskEntity ->
        OwaspResponse(
            owaspRiskEntity.year!!,
            owaspRiskEntity.name!!,
            owaspRiskEntity.description ?: "",
            owaspRiskEntity.created!!,
            owaspRiskEntity.lastModified!!
        )
    }
}