package com.aluiziodeveloper.bookmarket.controller

import com.aluiziodeveloper.bookmarket.controller.request.PostBookRequest
import com.aluiziodeveloper.bookmarket.controller.request.PutBookRequest
import com.aluiziodeveloper.bookmarket.extension.toBookModel
import com.aluiziodeveloper.bookmarket.model.BookModel
import com.aluiziodeveloper.bookmarket.service.BookService
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
@RequestMapping("books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {
    @GetMapping
    fun findAll(@RequestParam name: String?): List<BookModel> =
        bookService.findAll(name)

    @GetMapping("/active")
    fun findAllActives(): List<BookModel> =
        bookService.findAllActives()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel =
        bookService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody requestBook: PostBookRequest) {
        val customer = customerService.findById(requestBook.customerId)
        bookService.create(requestBook.toBookModel(customer))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody requestBook: PutBookRequest) {
        val book = bookService.findById(id)
        bookService.update(requestBook.toBookModel(book))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) =
        bookService.delete(id)
}