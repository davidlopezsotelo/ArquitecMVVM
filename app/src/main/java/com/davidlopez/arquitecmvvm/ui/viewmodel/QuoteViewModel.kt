package com.davidlopez.arquitecmvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidlopez.arquitecmvvm.data.model.QuoteModel
import com.davidlopez.arquitecmvvm.data.model.QuoteProvider
import com.davidlopez.arquitecmvvm.domain.GetQuotesUseCase
import com.davidlopez.arquitecmvvm.domain.GetRamdomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//preparamos la clase para ser inyectada

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseCase: GetQuotesUseCase,
    private val getRamdomQuoteUseCase: GetRamdomQuoteUseCase
): ViewModel() {

    val quotemodel=MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>() // muestra u oculta el progress bar

    //llamaos a nuestro caso de uso
    /*var getQuoteUseCase = GetQuotesUseCase()
    var getRamdomQuoteUseCase=GetRamdomQuoteUseCase()*/

    fun onCreate() {

        viewModelScope.launch {

            // si realizamos una operacion que puede tardar:
            // ponemos el progres bar en true.
            isLoading.postValue(true)

            val result = getQuoteUseCase()

            if (!result.isNullOrEmpty()){
                quotemodel.postValue(result[0])
                // cuando el proceso termine apagamos el progress bar
                isLoading.postValue(false)
            }
        }

    }

   fun randomQuote(){
       isLoading.postValue(true)
        //val currentQuote= QuoteProvider.random()
        //quotemodel.postValue(currentQuote)
       val quote =getRamdomQuoteUseCase
       if (quote!=null){
           //quotemodel.postValue(quote)// reparar???
       }

       isLoading.postValue(false)
    }


}




