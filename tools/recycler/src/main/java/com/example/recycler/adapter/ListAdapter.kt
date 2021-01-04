package com.example.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recycler.viewholder.BaseListItem
import com.example.recycler.viewholder.BaseViewHolder

class ListAdapter<U : Any> : ListAdapter<BaseListItem<U>, BaseViewHolder<U>>(diffUtil<U, BaseListItem<U>>()) {

    override fun getItemViewType(position: Int): Int = getItem(position)?.viewId
                ?: throw IllegalArgumentException("item not found")

    override fun onBindViewHolder(holder: BaseViewHolder<U>, position: Int) {
        getItem(position)?.run {
            holder.bind(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<U> {
        return BaseViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }


}