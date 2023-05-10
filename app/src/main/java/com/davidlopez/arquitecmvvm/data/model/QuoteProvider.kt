package com.davidlopez.arquitecmvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor(){

    companion object {

        var quotes:List<QuoteModel> = emptyList()

        //creamos funcion random que nos devolvera un quote random
/*
        fun random(): QuoteModel {
            val posicion = (0..5).random()
            return quote[posicion]
        }

        private val quote = listOf<QuoteModel>(
            QuoteModel(quote = "cita 1", author = "autor A"),
            QuoteModel(quote = "cita 2", author = "autor B"),
            QuoteModel(quote = "cita 3", author = "autor C"),
            QuoteModel(quote = "cita 4", author = "autor D"),
            QuoteModel(quote = "cita 5", author = "autor E"),
            QuoteModel(quote = "cita 6", author = "autor F")
        )*/
    }
}




/*
companion object es la representación de un miembro
que se puede llamar directamente del nombre de una clase,
 sin la creación previa de una instancia de dicha clase.
 Se podría decir que es el equivalente a los miembros estáticos de Java,
  solo que en Kotlin no existe la palabra static.
 */