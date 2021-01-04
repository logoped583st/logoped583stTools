package com.example.recycler.viewholder

interface RecyclerItem<U : Any> {
    val unique: U
    override fun equals(other: Any?): Boolean
}