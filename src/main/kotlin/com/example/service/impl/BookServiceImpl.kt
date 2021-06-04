package com.example.service.impl

import com.example.dto.BookDTO
import com.example.entity.Book
import com.example.mapper.BookMapper
import com.example.repository.BookRepository
import com.example.repository.ProducerRepository
import com.example.service.BookService
import java.beans.Transient
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class BookServiceImpl: BookService {

    @Inject
    lateinit var bookRepository: BookRepository

    @Inject
    lateinit var producerRepository: ProducerRepository

    @Inject
    lateinit var bookMapper: BookMapper

    override fun create(bookDTO: BookDTO): Book {
        var book1: Book = bookMapper.convertToEntity(bookDTO)
        book1.producer = producerRepository.findById(bookDTO.producerId).get()
        return bookRepository.save(book1)
    }

    override fun findAll(): List<Book> {
        return bookRepository.findAll().distinct()
    }

    override fun delete(id: Long): Unit {
        bookRepository.deleteById(id)
    }

    override fun findById(id: Long): Book {
        return bookRepository.findById(id).get()
    }
}