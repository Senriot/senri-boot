package com.senri.boot.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
class ApplicationProperties
{
    var name: String? = null
    var description: String? = null
    var security: Security = Security()


    class Security
    {
        var contentSecurityPolicy =
            "default-src 'self'; frame-src 'self' data:; script-src 'self' 'unsafe-inline' 'unsafe-eval' https://storage.googleapis.com; style-src 'self' 'unsafe-inline'; img-src 'self' data:; font-src 'self' data:"
        var clientAuthorization = ClientAuthorization()
        var authentication: Authentication = Authentication()
    }

    class ClientAuthorization
    {
        var accessTokenUri: String? = null

        var tokenServiceId: String? = null

        var clientId: String? = null

        var clientSecret: String? = null
    }

    class Authentication
    {
        var jwt: Jwt = Jwt()
    }

    class Jwt
    {
        var secret: String? = null
        var base64Secret: String? = null
        var tokenValidityInSeconds: Long = 0
        var tokenValidityInSecondsForRememberMe: Long = 0
    }
}
