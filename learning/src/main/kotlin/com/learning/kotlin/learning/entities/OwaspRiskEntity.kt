package com.learning.kotlin.learning.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "owasp_risk")
class OwaspRiskEntity {

    @Id
    lateinit var id: String ;
    var year: String? = null;
    var name: String? = null;
    var description: String? = null;
    var created: Instant? = null;
    var lastModified: Instant? = null;
}