package com.example.entity

import javax.persistence.*

@Entity
@Table(name = "books")
class Book (

    @Column(name = "title" , nullable = true)
    var title: String? = "",

    @Column(name = "page")
    var page: Int? = 0,

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "producer_id")
    var producer: Producer? = null
): Base() {
}