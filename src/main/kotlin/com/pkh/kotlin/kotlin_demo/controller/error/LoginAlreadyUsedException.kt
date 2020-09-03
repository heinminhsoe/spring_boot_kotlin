package com.pkh.kotlin.kotlin_demo.controller.error

import com.pkh.kotlin.kotlin_demo.controller.error.BadRequestAlertException
import org.zalando.problem.Exceptional

class LoginAlreadyUsedException :
    BadRequestAlertException(LOGIN_ALREADY_USED_TYPE, "Login name already used!", "userManagement", "userexists") {

    override fun getCause(): Exceptional? = super.cause
}
