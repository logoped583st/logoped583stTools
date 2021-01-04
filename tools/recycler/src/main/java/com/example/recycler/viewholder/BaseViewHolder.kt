package com.example.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<U : Any>(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: BaseListItem<U>) {
        item.bind(view)
    }
}
