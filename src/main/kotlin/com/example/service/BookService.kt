package com.example.service

import com.example.dto.BookDTO
import com.example.entity.Book

interface BookService {
    fun create(bookDTO: BookDTO): Book
    fun findAll(): List<Book>
    fun delete(id: Long): Unit
    fun findById(id: Long): Book
}