package com.example.recycler

interface RecyclerItem<U : Any> {
    val unique: U
    override fun equals(other: Any?): Boolean
}