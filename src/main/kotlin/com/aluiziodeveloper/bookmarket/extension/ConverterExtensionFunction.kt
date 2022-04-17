package com.aluiziodeveloper.bookmarket.extension

import com.aluiziodeveloper.bookmarket.controller.request.PostBookRequest
import com.aluiziodeveloper.bookmarket.controller.request.PostCustomerRequest
import com.aluiziodeveloper.bookmarket.controller.request.PutBookRequest
import com.aluiziodeveloper.bookmarket.controller.request.PutCustomerRequest
import com.aluiziodeveloper.bookmarket.enums.BookStatus
import com.aluiziodeveloper.bookmarket.model.BookModel
import com.aluiziodeveloper.bookmarket.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}