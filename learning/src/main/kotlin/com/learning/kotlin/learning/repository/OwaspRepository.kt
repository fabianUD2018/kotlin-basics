package com.learning.kotlin.learning.repository

import com.learning.kotlin.learning.entities.OwaspRiskEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OwaspRepository : CrudRepository<OwaspRiskEntity, String> {

    fun findByNameAndYear(name: String, year:String) : OwaspRiskEntity?;
}