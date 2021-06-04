package com.example.entity

import javax.persistence.*

@Entity
@Table(name = "role")
class Role(
    @Column(name= "name")
    var name: String? = "",

    @ManyToMany(mappedBy = "role", fetch = FetchType.LAZY)
    var user: MutableList<User> = mutableListOf()
): Base() {
}