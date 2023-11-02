package com.learning.kotlin.learning.dtos

import java.time.Instant

data class OwaspResponse (val year:String, val name:String, val description: String, val created: Instant, val lastModified: Instant){
}