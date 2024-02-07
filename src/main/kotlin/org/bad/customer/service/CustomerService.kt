package org.bad.customer.service

import org.bad.customer.entity.Customer
import org.bad.customer.model.CustomerDTORequest
import org.bad.customer.model.CustomerDTOResponse
import org.bad.customer.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.jvm.optionals.getOrNull

@Service
class CustomerService(private val repository: CustomerRepository) {

    fun create(newCustomer: CustomerDTORequest): CustomerDTOResponse {
        val save = repository.save(setCustomerDTORequestToCustomer(newCustomer))
        return setCustomerToCustomerDTOResponse(save)
    }

    fun get(id: Long): CustomerDTOResponse? {
        return repository.findById(id).getOrNull()?.let { setCustomerToCustomerDTOResponse(it) }
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun setCustomerDTORequestToCustomer(customerRequest: CustomerDTORequest) : Customer {

        val customer = Customer()
        customer.name = customerRequest.name
        customer.address = customerRequest.address
        customer.dob = customerRequest.dob
        customer.active = true
        customer.modifiedDate = null
        customer.modifiedBy = null
        customer.createdDate = LocalDate.now()
        customer.createdBy = customerRequest.userId
        return customer

    }

    fun setCustomerToCustomerDTOResponse(customer: Customer) : CustomerDTOResponse {

        val customerResponse = CustomerDTOResponse()
        customerResponse.id = customer.id!!
        customerResponse.name = customer.name
        customerResponse.address = customer.address
        customerResponse.dob = customer.dob
        customerResponse.active = customer.active
        customerResponse.modifiedDate = customer.modifiedDate
        customerResponse.modifiedBy = customer.modifiedBy
        customerResponse.createdDate = customer.createdDate
        customerResponse.createdBy = customer.createdBy
        return customerResponse

    }
}