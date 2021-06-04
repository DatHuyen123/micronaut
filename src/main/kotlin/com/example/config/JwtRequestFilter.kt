package com.example.config

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.FilterChain
import io.micronaut.http.filter.HttpServerFilter
import io.micronaut.http.filter.OncePerRequestHttpServerFilter
import io.micronaut.http.filter.ServerFilterChain
import io.micronaut.security.filters.AuthenticationFetcher
import io.micronaut.security.utils.SecurityService
import org.reactivestreams.Publisher
import javax.inject.Inject
import javax.inject.Singleton
import io.micronaut.security.filters.SecurityFilter
import io.micronaut.security.filters.SecurityFilterOrderProvider
import io.micronaut.security.handlers.RejectionHandler
import io.micronaut.security.rules.SecurityRule

@Filter("/hello","")
class JwtRequestFilter(securityRules: MutableCollection<SecurityRule>?,
                       authenticationFetchers: MutableCollection<AuthenticationFetcher>?,
                       rejectionHandler: RejectionHandler?, securityFilterOrderProvider: SecurityFilterOrderProvider?
) : /*HttpServerFilter,*/ SecurityFilter(
    securityRules, authenticationFetchers, rejectionHandler, securityFilterOrderProvider
) {

    /*override fun doFilter(request: HttpRequest<*>?, chain: ServerFilterChain?): Publisher<MutableHttpResponse<*>> {
        return chain?.proceed(request) ?: Publisher {  }
    }*/

    override fun doFilterOnce(request: HttpRequest<*>?, chain: ServerFilterChain?): Publisher<MutableHttpResponse<*>> {
        return chain?.proceed(request) ?: Publisher {  }
    }
}