package com.example.api

import com.example.dto.UserDTO
import com.example.dto.search.UserSearchDTO
import com.example.service.UserService
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/user")
class UserAPI {

    @Inject
    lateinit var userService: UserService

    @Post("/create-or-update" , consumes = [MediaType.APPLICATION_JSON], processes = [MediaType.APPLICATION_JSON])
    fun create(@Body userDTO: UserDTO): HttpResponse<Any> {
        val httpResponse: HttpResponse<Any>
        httpResponse = HttpResponse.status<Any>(HttpStatus.OK).body(userService.create(userDTO))
        return httpResponse
    }

    @Get("/get-all" , consumes = [MediaType.APPLICATION_JSON])
    fun getAll(): HttpResponse<Any> {
        val httpResponse: HttpResponse<Any>
        httpResponse = HttpResponse.status<Any>(HttpStatus.OK).body(userService.getAll())
        return httpResponse
    }

    @Post("/get-all-by-condition" , consumes = [MediaType.APPLICATION_JSON], processes = [MediaType.APPLICATION_JSON])
    fun getAllByCondition(@Body userSearchDTO: UserSearchDTO): HttpResponse<Any> {
        val httpResponse: HttpResponse<Any>
        httpResponse = HttpResponse.status<Any>(HttpStatus.OK).body(userService.getAllByCondition(userSearchDTO))
        return httpResponse
    }

    @Delete("/delete/{userId}")
    fun delete(@PathVariable("userId") id: Long): Unit {
        userService.delete(id)
    }
}