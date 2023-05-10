package com.davidlopez.arquitecmvvm.data.network

import com.davidlopez.arquitecmvvm.core.RetrofitHelper
import com.davidlopez.arquitecmvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// clase que devuelve un servicio de internet cada ved que se invoca
class QuoteService @Inject constructor(private val api:QuoteApiClient){

    //llamamos a la intreface RetrofitHelper para acceder a su funcion
    private val retrofit = RetrofitHelper.getRetrofit()

    //creamos una funcion que devuelve un response de una lista de quotes

    suspend fun getQuotes():List<QuoteModel>{

        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()// si es nulo, devuelve una lista vacia.

        }


    }


}