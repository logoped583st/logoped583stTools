package com.example.recycler.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.RecyclerItem

class ListAdapter<U : Any, I : RecyclerItem<U>, VH : RecyclerView.ViewHolder> : ListAdapter<I, VH>(diffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        TODO("Not yet implemented")
    }

}