package com.example.democarousel.common.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.democarousel.R
import com.example.democarousel.databinding.CarouselComponentViewBinding
import com.example.democarousel.presentation.ui.CustomListAdapter
import com.example.democarousel.presentation.ui.DataItem

class CarouselView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
): ConstraintLayout(context,attrs,defStyle) {

    private val binding: CarouselComponentViewBinding =
        CarouselComponentViewBinding.inflate(LayoutInflater.from(context), this, true)
    private val adapter by lazy { CustomListAdapter(context) }


    init {

        if (isInEditMode){
            val listPlaceHolder = mutableListOf<DataItem>()

            listPlaceHolder.apply {
                add(DataItem(resource = R.drawable.ic_launcher_background, title = "My title", sound =  R.raw.beep))
                add(DataItem(resource = R.drawable.ic_launcher_background, title = "My title", sound = R.raw.beep))
                add(DataItem(resource = R.drawable.ic_launcher_background, title = "My title", sound =  R.raw.beep))
                add(DataItem(resource = R.drawable.ic_launcher_background, title = "My title", sound = R.raw.beep))
            }

            setList(listPlaceHolder)
        }

        configList()


    }



    private fun configList(){
        binding.cnsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.cnsList.adapter = adapter
    }

    fun setList(list:List<DataItem>){
        adapter.submitList(list)
    }

}