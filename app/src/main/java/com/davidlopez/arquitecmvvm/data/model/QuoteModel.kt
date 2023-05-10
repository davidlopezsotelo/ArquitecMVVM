package com.davidlopez.arquitecmvvm.data.model

import com.google.gson.annotations.SerializedName
/*
creamos un dataclasss para generar los documentos que queremos guardar
 */

/*
añadimos el @SerializedName, por si lod datos que recuperamos del retrofit se llaman de forma distinta.
 https://www.youtube.com/watch?v=7FptmAjBdsA&list=PL8ie04dqq7_MvhtWlcIFS9L3_4EWatd-V&index=2
 */

data class QuoteModel (@SerializedName("quote")val quote:String?,@SerializedName("author")val author:String?)