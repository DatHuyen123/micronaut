package com.example.service

import com.example.dto.UserDTO
import com.example.dto.search.UserSearchDTO

interface UserService {
    fun create(userDTO: UserDTO): UserDTO
    fun getAll(): List<UserDTO>
    fun delete(id: Long): Unit
    fun getAllByCondition(userSearchDTO: UserSearchDTO): List<UserDTO>
}