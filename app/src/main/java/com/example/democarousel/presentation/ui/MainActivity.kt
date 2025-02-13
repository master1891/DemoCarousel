package com.example.democarousel.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.democarousel.R
import com.example.democarousel.common.ModuleViewModel
import com.example.democarousel.common.ViewModelFactory
import com.example.democarousel.databinding.ActivityMainBinding
import com.example.democarousel.presentation.states.CarouselUIState
import com.example.democarousel.presentation.viewmodels.CarouselViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var  binding:ActivityMainBinding

    private val viewModel by viewModels <CarouselViewModel>() {
        ViewModelFactory(
            ModuleViewModel.CAROUSEL_VIEW_MODEL,
            this,
            null,
            binding.root.context
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initListeners()
        initRequest()

    }


    private fun initListeners(){
        lifecycleScope.launch {
            viewModel.carouselState.collect(::handleState)
        }
    }

    private fun initRequest(){
        viewModel.requestData()
    }

    private fun handleState(carouselUIState: CarouselUIState){

        when(carouselUIState){
            CarouselUIState.Error -> {}
            CarouselUIState.Init -> {}
            is CarouselUIState.Success ->{
                binding.carouselView.setList(carouselUIState.list)
                binding.carouselView1.setList(carouselUIState.list)
                binding.carouselView2.setList(carouselUIState.list)
            }
        }
    }

}