package com.example.mapper

import com.example.dto.BookDTO
import com.example.entity.Book
import org.mapstruct.Mapper
import org.mapstruct.Mappings

@Mapper(
    componentModel = "jsr330"
)
interface BookMapper {

    @Mappings
    fun convertToEntity(bookDTO: BookDTO): Book
}