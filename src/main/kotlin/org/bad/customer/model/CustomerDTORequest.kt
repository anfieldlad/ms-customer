package org.bad.customer.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class CustomerDTORequest (
    @JsonProperty("id")
    var id: Long?,
    @JsonProperty("name")
    var name: String,
    @JsonProperty("address")
    var address: String,
    @JsonProperty("dob")
    var dob: LocalDate,
    @JsonProperty("userId")
    var userId: String
)