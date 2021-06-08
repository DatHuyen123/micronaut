package com.example.api

import com.example.dto.BookDTO
import com.example.entity.Book
import com.example.repository.BookRepository
import com.example.service.BookService
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
//import io.micronaut.security.annotation.Secured
import javax.inject.Inject

//@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api/admin/book")
class BookAPI {

    @Inject
    lateinit var bookService: BookService

    @Secured("ROLE_USER")
    @Get("/get-all")
    fun getAll(): List<Book> {
        var books: Iterable<Book> = bookService.findAll()
        return books.distinct()
    }

    @Get(value = "/book-test", consumes = [MediaType.TEXT_PLAIN])
    fun hello(): String {
        return "a"
    }

    @Post("/add", consumes = [MediaType.APPLICATION_JSON], processes = [MediaType.APPLICATION_JSON])
    fun addBook(@Body bookDTO: BookDTO): HttpResponse<Any> {
        val httpResponse: HttpResponse<Any>
        httpResponse = HttpResponse.status<Any>(HttpStatus.OK).body<Any>(bookService.create(bookDTO))
        return httpResponse
    }

    @Delete("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Unit {
        bookService.delete(id)
    }

    @Get("/find-one" , consumes = [MediaType.APPLICATION_JSON], processes = [MediaType.APPLICATION_JSON])
    fun findById(@Parameter("id") id: Long): HttpResponse<Any> {
        val httpResponse: HttpResponse<Any>
        httpResponse = HttpResponse.status<Any>(HttpStatus.OK).body<Any>(bookService.findById(id))
        return httpResponse
    }

}