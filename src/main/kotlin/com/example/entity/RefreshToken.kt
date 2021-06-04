package com.example.entity

import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.MappedEntity
import java.time.Instant
import javax.validation.constraints.NotBlank

@MappedEntity
class RefreshToken(
    @NotBlank
    var username: String,

    @NotBlank
    var refreshToken: String,

    var revoked: Boolean,

    @DateCreated
    var dateCreated: Instant? = null,
): Base() {
}