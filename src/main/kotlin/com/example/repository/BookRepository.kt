package com.example.repository

import com.example.entity.Book
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface BookRepository: CrudRepository<Book , Long> {
}