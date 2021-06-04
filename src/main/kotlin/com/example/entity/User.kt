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

    @ManyToMany(fetch = FetchType.LAZY)
    var role: MutableList<Role> = mutableListOf()
): Base() {
}