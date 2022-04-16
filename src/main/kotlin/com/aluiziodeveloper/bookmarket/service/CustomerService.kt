package com.aluiziodeveloper.bookmarket.service

import com.aluiziodeveloper.bookmarket.model.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun findAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun findById(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun create(customer: CustomerModel) {
        var id = if(customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()
        customer.id = id
        customers.add(customer)
    }

    fun update(customer: CustomerModel) {
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(@PathVariable id: String) {
        customers.removeIf { it.id == id }
    }
}