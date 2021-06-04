package com.example.repository

import com.example.entity.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository: CrudRepository<User , Long> {
    fun findByUsername(username: String): User
}