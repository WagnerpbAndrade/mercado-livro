package com.wagnerandrade.mercadolivro.controller

import com.wagnerandrade.mercadolivro.model.CustomerModel
import com.wagnerandrade.mercadolivro.request.PostCustomerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customers.filter { it.id.equals(id) }.first()
    }

    @GetMapping
    fun getAll(): List<CustomerModel> {
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody newCostumer: PostCustomerRequest){
        var id = if(customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(CustomerModel(id, newCostumer.name, newCostumer.email))
    }
}