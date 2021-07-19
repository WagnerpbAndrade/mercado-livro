package com.wagnerandrade.mercadolivro

import com.wagnerandrade.mercadolivro.model.CustomerModel
import com.wagnerandrade.mercadolivro.request.PostCustomerRequest
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CustomerService {

    private val _customers = mutableListOf<CustomerModel>()

    fun getCustomer(id: String) : CustomerModel {
        return _customers.stream()
            .filter { it -> it.id.equals(id)}
            .findFirst()
            .orElseThrow { RuntimeException("Customer not found!") }
    }

    fun getAll(): List<CustomerModel> {
        return _customers
    }

    fun create(request: PostCustomerRequest) {
        var id = if(_customers.isEmpty()) {
            1
        } else {
            _customers.last().id.toInt() + 1
        }.toString()

        _customers.add(CustomerModel(id, request.name, request.email))
    }
}