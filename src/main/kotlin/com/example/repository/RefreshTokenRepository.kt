package com.example.repository

import com.example.entity.RefreshToken
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*
import javax.transaction.Transactional
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Repository
interface RefreshTokenRepository: CrudRepository<RefreshToken , Long> {

    fun save(username: @NotBlank String,
             refreshToken: @NotBlank String,
             revoked: @NotNull Boolean): RefreshToken?

    fun findByRefreshToken(refreshToken: @NotBlank String): Optional<RefreshToken>

    fun updateByUsername(username: @NotBlank String,
                         revoked: @NotNull Boolean): Long

}