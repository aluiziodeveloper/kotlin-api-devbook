package com.aluiziodeveloper.bookmarket.service

import com.aluiziodeveloper.bookmarket.model.CustomerModel
import com.aluiziodeveloper.bookmarket.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {
    fun findAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContainingIgnoreCase(it)
        }
        return customerRepository.findAll().toList()
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun update(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer not found")
        }
        customerRepository.save(customer)
    }

    fun delete(@PathVariable id: Int) {
        if(!customerRepository.existsById(id)) {
            throw Exception("Customer not found")
        }
        customerRepository.deleteById(id)
    }
}