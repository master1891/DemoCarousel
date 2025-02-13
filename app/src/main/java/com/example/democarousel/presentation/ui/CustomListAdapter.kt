package com.example.democarousel.presentation.ui

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import com.example.democarousel.R
import com.example.democarousel.databinding.CardItemBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.democarousel.util.ExoplayerHelper

class CustomListAdapter(context: Context) : ListAdapter<DataItem, RecyclerView.ViewHolder>(
    KpiDiffCallback()
) {
    private var selectedPosition = 0
    val TAG = "CustomListAdapter"
    private val exoplayerHelper:ExoplayerHelper = ExoplayerHelper(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CustomViewHolder(
            binding = CardItemBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val customViewHolder = holder as CustomViewHolder
        customViewHolder.bind(item)


        val context = holder.itemView.context
        val selectedHeightDp = context.resources.getDimensionPixelSize(R.dimen.kpi_selected_height)
        val defaultHeightDp = context.resources.getDimensionPixelSize(R.dimen.kpi_unselected_height)
        val topMarginDp =
            context.resources.getDimensionPixelSize(R.dimen.zcds_margin_padding_size_small)
        val defaultMarginDp =
            context.resources.getDimensionPixelSize(R.dimen.zcds_margin_padding_size_none)


        with(holder.itemView) {
            // Configuración dinámica de márgenes y altura
            layoutParams = (layoutParams as ViewGroup.MarginLayoutParams).apply {
                topMargin = if (position == selectedPosition) defaultMarginDp else topMarginDp
                height = if (position == selectedPosition) selectedHeightDp else defaultHeightDp
            }

            // Cambia el tinte del fondo si está seleccionado
            backgroundTintList = if (position == selectedPosition) {
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.cns_green_300))
            } else {
                null
            }

            // Configuración del clic para seleccionar ítem
            setOnClickListener {
                val previousPosition = selectedPosition
                selectedPosition = customViewHolder.adapterPosition
                notifyItemChanged(previousPosition)
                notifyItemChanged(selectedPosition)
            }
        }


    }

    inner class CustomViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataItem) {
            binding.cnsIconImage.setImageResource(item.resource)
            binding.btnPay.setOnClickListener {
                exoplayerHelper.play(item.sound)
                exoplayerHelper.release()
            }
        }
    }

    class KpiDiffCallback : DiffUtil.ItemCallback<DataItem>() {

        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }

    }

}