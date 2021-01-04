package com.example.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.recycler.viewholder.BaseListItem
import com.example.recycler.viewholder.BaseViewHolder
import com.example.recycler.viewholder.RecyclerItem

class PaginationAdapter<U : Any> : PagingDataAdapter<BaseListItem<U>, BaseViewHolder<U>>(diffUtil<U, BaseListItem<U>>()) {

    final override fun getItemViewType(position: Int): Int = getItem(position)?.viewId
            ?: throw IllegalArgumentException("item not found")

    final override fun onBindViewHolder(holder: BaseViewHolder<U>, position: Int) {
        getItem(position)?.run {
            holder.bind(this)
        }
    }

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<U> {
        return BaseViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }

}


internal fun <U : Any, D : RecyclerItem<U>> diffUtil() = object : DiffUtil.ItemCallback<D>() {
    override fun areItemsTheSame(oldItem: D, newItem: D): Boolean {
        return oldItem.unique == newItem.unique
    }

    override fun areContentsTheSame(oldItem: D, newItem: D): Boolean {
        return oldItem == newItem
    }
}
