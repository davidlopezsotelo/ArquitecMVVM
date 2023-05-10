package com.davidlopez.arquitecmvvm.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.davidlopez.arquitecmvvm.databinding.ActivityMainBinding
import com.davidlopez.arquitecmvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint


// 1º activamos viewbinding en features (build gradle : app) https://www.youtube.com/watch?v=yE2Y2q4iWpU

// 2º añadimos etiqueta de dagger hilt
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main) -> cambiar por binding
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperamos las quotes para guardarla en la memoria
        quoteViewModel.onCreate()

        //llamamos al viewmodel
        quoteViewModel.quotemodel.observe(this,Observer { currentQuote ->
                binding.tvQuote.text = currentQuote.quote
                binding.tvAuthor.text = currentQuote.author
            })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible=it
        })
        //mostrar en los textview al hacer click
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

    }
}


