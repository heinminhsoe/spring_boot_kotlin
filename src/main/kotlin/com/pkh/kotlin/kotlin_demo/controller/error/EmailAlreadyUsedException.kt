package com.pkh.kotlin.kotlin_demo.controller.error

import com.pkh.kotlin.kotlin_demo.controller.error.BadRequestAlertException

class EmailAlreadyUsedException :
    BadRequestAlertException(EMAIL_ALREADY_USED_TYPE, "Email is already in use!", "userManagement", "emailexists") {

    companion object {
        private const val serialVersionUID = 1L
    }
}
