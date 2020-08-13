package com.pkh.kotlin.kotlin_demo.dto

import javax.validation.constraints.NotBlank

data class PersonDTO(
    var id: Long? = null,

    @NotBlank
    var name: String? = null,

    @NotBlank
    var address: String? = null
)