package com.pkh.kotlin.kotlin_demo.entity

import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tnc_role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
data class Role(
    @Id
    var name: String? = null
) {
    override fun toString() = "Role { name : $name }"
}