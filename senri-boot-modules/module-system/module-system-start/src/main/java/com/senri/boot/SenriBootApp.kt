package com.senri.boot

import com.senri.boot.config.ApplicationProperties
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.core.env.Environment

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties::class)
class SenriBootApp(private val env: Environment)
{
    private val log = LoggerFactory.getLogger(javaClass)

    companion object
    {
        @JvmStatic
        fun main(args: Array<String>)
        {
            runApplication<SenriBootApp>(*args)
        }
    }
}