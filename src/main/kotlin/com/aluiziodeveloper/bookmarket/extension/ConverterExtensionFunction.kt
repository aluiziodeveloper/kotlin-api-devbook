package com.aluiziodeveloper.bookmarket.extension

import com.aluiziodeveloper.bookmarket.controller.request.PostCustomerRequest
import com.aluiziodeveloper.bookmarket.controller.request.PutCustomerRequest
import com.aluiziodeveloper.bookmarket.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}