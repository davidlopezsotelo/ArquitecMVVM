package com.davidlopez.arquitecmvvm.domain

import com.davidlopez.arquitecmvvm.data.QuoteRepository
import com.davidlopez.arquitecmvvm.data.model.QuoteModel
import javax.inject.Inject


// clase que se encarga de gestionar los casos de uso

class GetQuotesUseCase @Inject constructor(
    private val repository:QuoteRepository
){

   // private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>?  = repository.getAllQuotes()

}