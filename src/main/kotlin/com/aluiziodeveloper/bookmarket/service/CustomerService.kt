package com.aluiziodeveloper.bookmarket.service

import com.aluiziodeveloper.bookmarket.enums.CustomerStatus
import com.aluiziodeveloper.bookmarket.model.CustomerModel
import com.aluiziodeveloper.bookmarket.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {
    fun findAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContainingIgnoreCase(it)
        }
        return customerRepository.findAll().toList()
    }

    fun findById(id: Int): CustomerModel =
        customerRepository.findById(id).orElseThrow()

    fun create(customer: CustomerModel) =
        customerRepository.save(customer)

    fun update(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer not found")
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)
        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }
}