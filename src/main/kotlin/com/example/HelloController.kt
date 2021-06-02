package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class HelloController {

    @Get(value = "/hello", consumes = [MediaType.TEXT_PLAIN])
    fun hello(): String {
        return "a"
    }
}