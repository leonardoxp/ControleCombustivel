package com.example.consumocombustivel2.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()