package com.example.service.impl

import com.example.dto.UserDTO
import com.example.dto.search.UserSearchDTO
import com.example.entity.User
import com.example.mapper.UserMapper
import com.example.repository.UserRepository
import com.example.service.UserService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserServiceImpl: UserService {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var userMapper: UserMapper

    override fun create(userDTO: UserDTO): UserDTO {
        var result: UserDTO
        if (userDTO.id == null) {
            result = userMapper.convertToDTO(userRepository.save(userMapper.convertToEntity(userDTO)))
        } else {
            result = userMapper.convertToDTO(userRepository.update(userMapper.convertToEntity(userDTO)))
        }
        return result
    }

    override fun getAll(): List<UserDTO> {
        return userMapper.convertToListDTO(userRepository.findAll().distinct())
    }

    override fun delete(id: Long) {
        userRepository.deleteById(id)
    }

    override fun getAllByCondition(userSearchDTO: UserSearchDTO): List<UserDTO> {
        var users: List<User> = userRepository.findByName(userSearchDTO.name)
        return userMapper.convertToListDTO(users)
    }

    override fun findOne(id: Long): UserDTO {
        return userMapper.convertToDTO(userRepository.findById(id).get())
    }
}