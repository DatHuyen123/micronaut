package com.example.api

import com.example.entity.Book
import com.example.repository.BookRepository
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.inject.Inject

@Controller("/api/book")
class BookAPI {

    @Inject
    lateinit var bookRepository: BookRepository

    @Get("/get-all")
    fun getAll(): List<Book> {
        var books: Iterable<Book> = bookRepository.findAll()
        return books.distinct()
    }

    @Get(value = "/book-test", consumes = [MediaType.TEXT_PLAIN])
    fun hello(): String {
        return "a"
    }

    @Post("/add", consumes = [MediaType.APPLICATION_JSON], processes = [MediaType.APPLICATION_JSON])
    fun addBook(@Body book: Book): HttpResponse<Any> {
        val httpResponse: HttpResponse<Any>
        httpResponse = HttpResponse.status<Any>(HttpStatus.OK).body<Any>(bookRepository.save(book))
        return httpResponse
    }
}