package com.senri.boot.common.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.Instant
import javax.persistence.Column

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

/**
 * Base abstract class for entities which will hold definitions for created, last modified by, created by,
 * last modified by attributes.
 */
abstract class AbstractAuditingEntity(

    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    @JsonIgnore
    var createdBy: String? = null,

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    var createdDate: Instant? = Instant.now(),

    @Column(name = "update_by", length = 50)
    @JsonIgnore
    var updateBy: String? = null,

    @LastModifiedDate
    @Column(name = "update_date")
    @JsonIgnore
    var updateDate: Instant? = Instant.now()

) : Serializable
{

    companion object
    {
        private const val serialVersionUID = 1L
    }
}
