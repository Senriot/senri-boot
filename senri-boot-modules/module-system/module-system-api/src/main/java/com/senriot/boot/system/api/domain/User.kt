package com.senriot.boot.system.api.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.senri.boot.common.domain.AbstractAuditingEntity
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.io.Serializable
import java.time.Instant
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * A user.
 */
@Table("jhi_user")
class User(

    @Id
    var id: Long? = null,

    @field:NotNull
    @field:Size(min = 1, max = 50)
    var login: String? = null,

    @JsonIgnore
    @field:NotNull
    @field:Size(min = 60, max = 60)
    @Column("password_hash")
    var password: String? = null,

    @field:Size(max = 50)
    @Column("first_name")
    var firstName: String? = null,

    @field:Size(max = 50)
    @Column("last_name")
    var lastName: String? = null,

    @field:Email
    @field:Size(min = 5, max = 254)
    var email: String? = null,

    @field:NotNull
    var activated: Boolean? = false,

    @field:Size(min = 2, max = 10)
    @Column("lang_key")
    var langKey: String? = null,

    @field:Size(max = 256)
    @Column("image_url")
    var imageUrl: String? = null,

    @field:Size(max = 20)
    @Column("activation_key")
    @JsonIgnore
    var activationKey: String? = null,

    @field:Size(max = 20)
    @Column("reset_key")
    var resetKey: String? = null,

    @Column("reset_date")
    var resetDate: Instant? = null,

    ) : AbstractAuditingEntity(), Serializable
{


    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other !is User) return false
        if (other.id == null || id == null) return false

        return id == other.id
    }

    override fun hashCode() = 31

    override fun toString() =
        "User{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", activated='" + activated + '\'' +
                ", langKey='" + langKey + '\'' +
                ", activationKey='" + activationKey + '\'' +
                "}"

    companion object
    {
        private const val serialVersionUID = 1L
    }
}
