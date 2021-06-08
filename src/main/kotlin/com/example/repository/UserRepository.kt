package com.example.repository

import com.example.entity.User
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import org.hibernate.annotations.Parameter

@Repository
interface UserRepository: CrudRepository<User , Long> {

    @Query("SELECT u.* FROM users u WHERE u.username = :username" , nativeQuery = true)
    fun findByUsername(username: String): User?

    @Query("SELECT u FROM users u WHERE u.name LIKE :name" , nativeQuery = true)
    fun findByName(name: String): List<User>
}