package com.pkh.kotlin.kotlin_demo.entity

import org.hibernate.annotations.*
import org.hibernate.annotations.Cache
import java.time.Instant
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tnc_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "login", unique = true, length = 50, nullable = false)
        var login: String? = null,

        @Column(name = "password_hash", length = 255, nullable = false)
        var password: String? = null,

        @Column(name = "name", length = 100, nullable = false)
        var name: String? = null,

        @Column(name = "email", unique = true, length = 100, nullable = true)
        var email: String? = null,

        @Column(name = "lang_key", length = 10)
        var langKey: String? = null,

        @Column(name = "last_modified_by", length = 100)
        var lastModifiedBy: String? = null,

        @CreationTimestamp
        @Column(name = "created_date")
        var createdDate: Instant? = Instant.now(),

        @UpdateTimestamp
        @Column(name = "modified_date")
        var modifiedDate: Instant? = Instant.now(),

        @ManyToMany
        @JoinTable(
                name = "tnc_user_role",
                joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "role_name", referencedColumnName = "name")]
        )
        @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
        @BatchSize(size = 20)
        var authorities: MutableSet<Role> = mutableSetOf()
) {
    override fun toString() = "User {" +
            "id: $id ," +
            "login: $login ," +
            "name: $name ," +
            "email: $email ," +
            "langKey: $langKey" +
            "}"
}