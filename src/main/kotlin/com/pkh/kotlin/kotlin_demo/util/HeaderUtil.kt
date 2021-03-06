package com.pkh.kotlin.kotlin_demo.util

import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


object HeaderUtil {
    private val log = LoggerFactory.getLogger(HeaderUtil::class.java)

    fun createAlert(applicationName: String, message: String?, param: String?): HttpHeaders {
        val headers = HttpHeaders()
        headers.add("X-$applicationName-alert", message)
        try {
            headers.add("X-$applicationName-params", URLEncoder.encode(param, StandardCharsets.UTF_8.toString()))
        } catch (unsupportedEncodingException: UnsupportedEncodingException) {
        }
        return headers
    }

    fun createEntityCreationAlert(applicationName: String, enableTranslation: Boolean, entityName: String, param: String): HttpHeaders {
        val message = if (enableTranslation) "$applicationName.$entityName.created" else "A new $entityName is created with identifier $param"
        return createAlert(applicationName, message, param)
    }

    fun createEntityUpdateAlert(applicationName: String, enableTranslation: Boolean, entityName: String, param: String): HttpHeaders {
        val message = if (enableTranslation) "$applicationName.$entityName.updated" else "A $entityName is updated with identifier $param"
        return createAlert(applicationName, message, param)
    }

    fun createEntityDeletionAlert(applicationName: String, enableTranslation: Boolean, entityName: String, param: String): HttpHeaders {
        val message = if (enableTranslation) "$applicationName.$entityName.deleted" else "A $entityName is deleted with identifier $param"
        return createAlert(applicationName, message, param)
    }

    fun createFailureAlert(applicationName: String?, enableTranslation: Boolean, entityName: String?, errorKey: String, defaultMessage: String?): HttpHeaders {
        log.error("Entity processing failed, {}", defaultMessage)
        val message = if (enableTranslation) "error.$errorKey" else defaultMessage!!
        val headers = HttpHeaders()
        headers.add("X-$applicationName-error", message)
        headers.add("X-$applicationName-params", entityName)
        return headers
    }
}