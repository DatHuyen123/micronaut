package com.example.dto

class UserDTO(
        var name: String? = "",
        var username: String? = "",
        var password: String? = "",
        var role: String = ""
): BaseDTO() {
}