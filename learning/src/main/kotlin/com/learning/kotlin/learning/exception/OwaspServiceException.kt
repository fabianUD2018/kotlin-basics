package com.learning.kotlin.learning.exception

class OwaspServiceException (override val message: String) : RuntimeException(message)