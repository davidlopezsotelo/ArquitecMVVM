package com.davidlopez.arquitecmvvm.domain

import com.davidlopez.arquitecmvvm.data.QuoteRepository
import com.davidlopez.arquitecmvvm.data.model.QuoteModel
import com.davidlopez.arquitecmvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRamdomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

    //private val repository=QuoteRepository()

    operator fun invoke():QuoteModel?{
        val quotes =  QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber=(0..quotes.size-1).random()
            return quotes[randomNumber]
        }
        return null
    }



}