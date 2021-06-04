package com.example.service

import com.example.entity.Producer

interface ProducerService {
    fun create(producer: Producer): Producer
    fun findOne(id: Long): Producer
}