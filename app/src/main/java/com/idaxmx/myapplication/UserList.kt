package com.idaxmx.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idaxmx.myapplication.databinding.CellUserBinding

class UserList(
    context: Context,
    attrs: AttributeSet?,
): RecyclerView(
    context, attrs
) {
    var data: List<User> = emptyList()
        set(value) {
            field = value
            adapter?.notifyItemRangeChanged(0, value.size)
        }

    init {
        this.adapter = Adapter()
        this.layoutManager = LinearLayoutManager(context)
    }


    private inner class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

        private inner class ViewHolder(
            private val userItem: UserItem
        ): RecyclerView.ViewHolder(userItem) {

            fun bind(user: User) {
                userItem.data = user
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val userItem = UserItem(context, null)
            return ViewHolder(userItem)
        }

        override fun getItemCount(): Int = data.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            data[position].also(holder::bind)
        }
    }
}