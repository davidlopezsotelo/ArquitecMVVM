package com.davidlopez.arquitecmvvm.data

import com.davidlopez.arquitecmvvm.data.model.QuoteModel
import com.davidlopez.arquitecmvvm.data.model.QuoteProvider
import com.davidlopez.arquitecmvvm.data.network.QuoteService
import com.davidlopez.arquitecmvvm.ui.viewmodel.QuoteViewModel
import javax.inject.Inject


// clase que gestiona a que parte accedemos


class QuoteRepository @Inject constructor(
    private val api:QuoteService
){

    //private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response= api.getQuotes()
        QuoteProvider.quotes=response
        return response
    }
}