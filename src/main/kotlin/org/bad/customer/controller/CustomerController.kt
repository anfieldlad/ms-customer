package org.bad.customer.controller

import org.bad.customer.model.CustomerDTORequest
import org.bad.customer.model.CustomerDTOResponse
import org.bad.customer.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/customer")
class CustomerController(var customerService: CustomerService) {

    @PostMapping("/create")
    fun createCustomer(@RequestBody newCustomer: CustomerDTORequest): CustomerDTOResponse {
        return customerService.create(newCustomer)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Long): CustomerDTOResponse {
        return customerService.get(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long) {
        customerService.delete(id)
    }
}