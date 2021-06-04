package com.example.entity

import javax.persistence.*

@MappedSuperclass
open class Base (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open var id: Long? = null
        ) {
}