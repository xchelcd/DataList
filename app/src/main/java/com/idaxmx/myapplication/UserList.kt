package com.idaxmx.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserList(
    context: Context,
    attrs: AttributeSet?,
): RecyclerView(
    context, attrs
) {
    var data: List<User> = emptyList()
        set(value) {
            field = value
            // adapter?.notifyItemRangeChanged(0, value.size)
            adapter?.notifyDataSetChanged()
        }

    init {
        this.adapter = Adapter()
        this.layoutManager = LinearLayoutManager(context)
    }


    inner class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

        var onUserSelected: ((User) -> Unit)? = null

        inner class ViewHolder(
            private val userItem: UserItem
        ): RecyclerView.ViewHolder(userItem) {

            fun bind(user: User) {
                userItem.data = user.also(::addListener)
            }

            private fun addListener(user: User) {
                userItem.setOnClickListener {
                    onUserSelected?.let(user::let)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val userItem = UserItem(context, null)
            return ViewHolder(userItem)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            data[position].also(holder::bind)
        }

        override fun getItemCount(): Int = data.size
    }
}