package com.example.mapper

import com.example.dto.UserDTO
import com.example.entity.User
import org.mapstruct.Mapper
import org.mapstruct.Mappings

@Mapper(
        componentModel = "jsr330"
)
interface UserMapper {

    @Mappings
    fun convertToListDTO(userDTOs: List<User>): List<UserDTO>

    @Mappings
    fun convertToEntity(userDTO: UserDTO): User

    @Mappings
    fun convertToDTO(user: User): UserDTO
}