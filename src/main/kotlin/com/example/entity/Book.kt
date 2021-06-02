package com.example.entity

import javax.persistence.*

@Entity
@Table(name = "books")
data class Book (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = 1,
    @Column(name = "title" , nullable = true)
    var title: String? = "",
    @Column(name = "page")
    var page: Int? = 0
        ) {
}