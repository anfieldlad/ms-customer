package org.bad.customer.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String,
    var address: String,
    var dob: LocalDate,
    var active: Boolean,
    var modifiedDate: LocalDate?,
    var modifiedBy: String?,
    var createdDate: LocalDate,
    var createdBy: String
) {
    constructor() : this(null, "", "", LocalDate.of(1900, 1, 1), false, null, null, LocalDate.of(1900, 1, 1),"") {

    }
}
