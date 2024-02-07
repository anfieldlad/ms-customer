package org.bad.customer.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class CustomerDTOResponse (
    @JsonProperty("id")
    var id: Long?,
    @JsonProperty("name")
    var name: String,
    @JsonProperty("address")
    var address: String,
    @JsonProperty("dob")
    var dob: LocalDate,
    @JsonProperty("active")
    var active: Boolean,
    @JsonProperty("modifiedDate")
    var modifiedDate: LocalDate?,
    @JsonProperty("modifiedBy")
    var modifiedBy: String?,
    @JsonProperty("createdDate")
    var createdDate: LocalDate,
    @JsonProperty("createdBy")
    var createdBy: String
) {
    constructor() : this(null, "", "", LocalDate.of(1900, 1, 1), false, null, null, LocalDate.of(1900, 1, 1),"") {

    }
}