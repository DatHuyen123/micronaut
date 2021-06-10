package com.example.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Column(name = "name")
    var name: String? = "",

    @Column(name = "username")
    var username: String? = "",

    @Column(name = "password")
    var password: String? = "",

    @Column(name = "age")
    var age: Int? = 0,

    @Column(name = "role")
    var role: String = ""
): Base() {
}