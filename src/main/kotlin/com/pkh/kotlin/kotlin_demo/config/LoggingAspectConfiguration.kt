package com.pkh.kotlin.kotlin_demo.config

import com.pkh.kotlin.kotlin_demo.config.aop.LoggingAspect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.core.env.Environment

@Configuration
@EnableAspectJAutoProxy
class LoggingAspectConfiguration {

    @Bean
    fun loggingAspect(env: Environment) = LoggingAspect()
}
