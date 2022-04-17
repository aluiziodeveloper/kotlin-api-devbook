package com.aluiziodeveloper.bookmarket.service

import com.aluiziodeveloper.bookmarket.enums.BookStatus
import com.aluiziodeveloper.bookmarket.model.BookModel
import com.aluiziodeveloper.bookmarket.model.CustomerModel
import com.aluiziodeveloper.bookmarket.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun findAll(name: String?): List<BookModel> {
        name?.let {
            return bookRepository.findByNameContainingIgnoreCase(it)
        }
        return bookRepository.findAll().toList()
    }

    fun findAllActives(): List<BookModel> =
        bookRepository.findByStatus(BookStatus.ATIVO).toList()

    fun findById(id: Int): BookModel =
        bookRepository.findById(id).orElseThrow()

    fun create(book: BookModel) =
        bookRepository.save(book)

    fun update(book: BookModel) =
        bookRepository.save(book)

    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.DELETADO
        update(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for (book in books) {
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }
}