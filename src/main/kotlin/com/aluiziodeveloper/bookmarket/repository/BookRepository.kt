package com.aluiziodeveloper.bookmarket.repository

import com.aluiziodeveloper.bookmarket.enums.BookStatus
import com.aluiziodeveloper.bookmarket.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
    fun findByNameContainingIgnoreCase(name: String): List<BookModel>
    fun findByStatus(status: BookStatus): List<BookModel>
}