package com.aluiziodeveloper.bookmarket.repository

import com.aluiziodeveloper.bookmarket.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int> {
    fun findByNameContainingIgnoreCase(name: String): List<CustomerModel>
}