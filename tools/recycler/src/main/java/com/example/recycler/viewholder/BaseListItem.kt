package com.example.recycler.viewholder

import android.view.View
import androidx.annotation.LayoutRes

abstract class BaseListItem<U : Any>(@LayoutRes val viewId: Int) : RecyclerItem<U> {

    abstract fun bind(view: View)

}