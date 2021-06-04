package com.example.dto

data class BookDTO(
    var title: String? = "",
    var page: Int? = 0,
    var producerId: Long
): BaseDTO() {
}