package com.example.dto

class UserDTO(
        var name: String? = "",
        var username: String? = "",
        var password: String? = "",
        var age: Int? = 0,
        var role: String = ""
): BaseDTO() {
}