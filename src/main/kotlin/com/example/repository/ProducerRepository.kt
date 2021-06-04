package com.example.repository

import com.example.entity.Producer
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ProducerRepository: CrudRepository<Producer, Long> {
}