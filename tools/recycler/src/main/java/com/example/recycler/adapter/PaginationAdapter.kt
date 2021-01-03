package com.example.recycler.adapter

import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.RecyclerItem

class PaginationAdapter<U : Any, I : RecyclerItem<U>, VH : RecyclerView.ViewHolder> : PagingDataAdapter<I, VH>(diffUtil<U, I>()) {
    override fun onBindViewHolder(holder: VH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        TODO("Not yet implemented")
    }

}


fun <U : Any, D : RecyclerItem<U>> diffUtil() = object : DiffUtil.ItemCallback<D>() {
    override fun areItemsTheSame(oldItem: D, newItem: D): Boolean {
        return oldItem.unique == newItem.unique
    }

    override fun areContentsTheSame(oldItem: D, newItem: D): Boolean {
        return oldItem == newItem
    }
}

fun test() {
    val adapter = PaginationAdapter<String, Test, TestVh>()
    adapter.addLoadStateListener {
        it.append as LoadState.Error
    }
    adapter.retry()
}

class TestVh(view: View) : RecyclerView.ViewHolder(view) {

}

data class Test(val a: String) : RecyclerItem<String> {

    override val unique: String
        get() = a

}