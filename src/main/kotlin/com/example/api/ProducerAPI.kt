package com.example.api

import com.example.entity.Producer
import com.example.service.ProducerService
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
//import io.micronaut.security.annotation.Secured
import javax.inject.Inject

//@Secured("isAuthenticated()")
@Controller("/api/producer")
class ProducerAPI {

    @Inject
    lateinit var producerService: ProducerService

    @Post("/create" , consumes = [MediaType.APPLICATION_JSON], processes = [MediaType.APPLICATION_JSON])
    fun create(@Body producer: Producer): HttpResponse<Any> {
        val httpResponse: HttpResponse<Any>
        httpResponse = HttpResponse.status<Any?>(HttpStatus.OK).body(producerService.create(producer))
        return httpResponse
    }

    @Get("/find-one" , consumes = [MediaType.APPLICATION_JSON])
    fun findOne(@Parameter("id") id: Long): HttpResponse<Any> {
        val httpResponse: HttpResponse<Any>
        httpResponse = HttpResponse.status<Any?>(HttpStatus.OK).body(producerService.findOne(id))
        return httpResponse
    }
}