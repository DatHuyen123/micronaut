package com.example.api

import com.example.dto.UserDTO
import com.example.service.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import javax.annotation.security.PermitAll
import javax.inject.Inject

@Controller("/api")
class RegisterAPI {

    @Inject
    lateinit var userService: UserService

    @PermitAll
    /*@Secured("ROLE_USER")*/
    @Post("/register" , consumes = [MediaType.APPLICATION_JSON], processes = [MediaType.APPLICATION_JSON])
    fun create(@Body userDTO: UserDTO): HttpResponse<Any> {
        val httpResponse: HttpResponse<Any>
        httpResponse = HttpResponse.status<Any>(HttpStatus.OK).body(userService.create(userDTO))
        return httpResponse
    }
}