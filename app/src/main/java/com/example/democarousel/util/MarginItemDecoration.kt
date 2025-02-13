package com.example.democarousel.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    private val horizontalSpaceWidth: Int,
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view) // Obtiene la posición del ítem
        val itemCount = state.itemCount // Número total de ítems en el RecyclerView

        with(outRect) {
            left =
                if (position == 0) 0 else horizontalSpaceWidth // Sin espacio a la izquierda del primer ítem
            right =
                if (position == itemCount - 1) 0 else horizontalSpaceWidth // Sin espacio a la derecha del último ítem
        }
    }
}
