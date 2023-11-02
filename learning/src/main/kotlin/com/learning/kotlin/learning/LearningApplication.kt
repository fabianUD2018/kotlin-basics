package com.learning.kotlin.learning

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class LearningApplication

fun main(args: Array<String>) {
	runApplication<LearningApplication>(*args)
}
