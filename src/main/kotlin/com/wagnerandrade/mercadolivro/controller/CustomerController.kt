package com.wagnerandrade.mercadolivro.controller

import com.wagnerandrade.mercadolivro.CustomerService
import com.wagnerandrade.mercadolivro.model.CustomerModel
import com.wagnerandrade.mercadolivro.request.PostCustomerRequest
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
class CustomerController(val customerService: CustomerService) {

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customerService.getCustomer(id)
    }

    @GetMapping
    fun getAll(): List<CustomerModel> {
        return customerService.getAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody newCostumer: PostCustomerRequest){
        return customerService.create(newCostumer)
    }
}