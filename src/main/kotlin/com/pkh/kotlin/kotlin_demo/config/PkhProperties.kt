package com.pkh.kotlin.kotlin_demo.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import java.util.*

@Configuration
@ConfigurationProperties(prefix = "pkh", ignoreUnknownFields = false)
class PkhProperties {
    val security = Security()
    val cors = CorsConfiguration()

    class Security {
        val clientAuthorization = ClientAuthorization()
        val authentication = Authentication()
        val rememberMe = RememberMe()
        val oauth2 = OAuth2()

        class OAuth2 {
            private val audience: MutableList<String?> = mutableListOf()

            fun getAudience(): List<String?> {
                return Collections.unmodifiableList(audience)
            }

            fun setAudience(audience: MutableList<String?>) {
                this.audience.addAll(audience)
            }
        }

        class RememberMe {
            var key: String? = null
        }

        class Authentication {
            val jwt = Jwt()

            class Jwt {
                var base64Secret: String? = null
                var tokenValidityInSeconds: Long = 1800L
                var tokenValidityInSecondsForRememberMe: Long = 2592000L
            }
        }

        class ClientAuthorization {
            var accessTokenUri: String? = null
            var tokenServiceId: String? = null
            var clientId: String? = null
            var clientSecret: String? = null
        }
    }
}