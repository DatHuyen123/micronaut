package com.example.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.lang.reflect.Proxy
import javax.persistence.*

@Entity
@Table(name = "reducer")
class Producer(
    @Column(name = "name")
    var name: String? = "",

    @OneToMany(mappedBy = "producer" , fetch = FetchType.LAZY  ,orphanRemoval=true)
    @JsonIgnore
    var books: MutableList<Book>? = mutableListOf<Book>()
): Base () {
}