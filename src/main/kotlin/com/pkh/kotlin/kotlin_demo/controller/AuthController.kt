package com.pkh.kotlin.kotlin_demo.controller

import com.fasterxml.jackson.annotation.JsonProperty
import com.pkh.kotlin.kotlin_demo.security.jwt.JWTFilter
import com.pkh.kotlin.kotlin_demo.security.jwt.TokenProvider
import org.slf4j.LoggerFactory
import javax.validation.Valid
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api/authenticate")
class AuthController(
    private val tokenProvider: TokenProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun authorize(@Valid @RequestBody loginRequest: LoginRequest): ResponseEntity<JWTToken>? {
        log.info("authorize")

            val authenticationToken = UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)

            val authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken)
            SecurityContextHolder.getContext().authentication = authentication

            val rememberMe = loginRequest.isRememberMe ?: false
            val jwt = tokenProvider.createToken(authentication, rememberMe)

            val httpHeaders = HttpHeaders()
            httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer $jwt")
            log.info("JWT Token -> $jwt")
            return ResponseEntity(JWTToken(jwt), httpHeaders, HttpStatus.OK)

    }

    class LoginRequest(
            @field:NotNull
            @field:Size(min = 1, max = 50)
            var username: String? = null,

            @field:NotNull
            @field:Size(min = 4, max = 100)
            var password: String? = null,

            var isRememberMe: Boolean? = null
    ) {
        override fun toString() = "LoginRequest {" +
                "username : $username " +
                ", rememberMe : $isRememberMe " +
                '}'
    }

    class JWTToken(@get:JsonProperty("id_token") var idToken: String?)
}
