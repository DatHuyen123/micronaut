package com.example.service.impl

import com.example.entity.Book
import com.example.entity.Producer
import com.example.repository.ProducerRepository
import com.example.service.ProducerService
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ProducerServiceImpl: ProducerService {

    @Inject
    lateinit var producerRepository: ProducerRepository

    override fun create(producer: Producer): Producer {
        return producerRepository.save(producer)
    }

    override fun findOne(id: Long): Producer {
        var book: Optional<Producer> = producerRepository.findById(id)
        if (!book.isPresent) {

        }
        return book.get()
    }
}