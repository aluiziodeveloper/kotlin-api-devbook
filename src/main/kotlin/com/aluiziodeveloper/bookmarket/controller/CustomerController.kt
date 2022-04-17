package com.aluiziodeveloper.bookmarket.controller

import com.aluiziodeveloper.bookmarket.controller.request.PostCustomerRequest
import com.aluiziodeveloper.bookmarket.controller.request.PutCustomerRequest
import com.aluiziodeveloper.bookmarket.extension.toCustomerModel
import com.aluiziodeveloper.bookmarket.model.CustomerModel
import com.aluiziodeveloper.bookmarket.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("customers")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun findAll(@RequestParam name: String?): List<CustomerModel> =
        customerService.findAll(name)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): CustomerModel =
        customerService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody requestCustomer: PostCustomerRequest) =
        customerService.create(requestCustomer.toCustomerModel())

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody requestCustomer: PutCustomerRequest) {
        val customer = customerService.findById(id)
        customerService.update(requestCustomer.toCustomerModel(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) =
        customerService.delete(id)
}