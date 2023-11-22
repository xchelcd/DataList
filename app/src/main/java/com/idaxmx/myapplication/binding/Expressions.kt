package com.idaxmx.myapplication.binding

import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import com.idaxmx.myapplication.model.User
import com.idaxmx.myapplication.ui.widget.UserList

@BindingAdapter("app:onUserSelected")
fun onUserSelected(v: UserList, callback: CallbackWithUser?) {
    val adapter = v.adapter as UserList.Adapter
    adapter.onUserSelected = { user ->
        callback?.invoke(user)
    }
}

@BindingAdapter("app:show")
fun showTextView(v: View, list: List<User>?) {
    v.isVisible = list?.isEmpty() ?: true
}

@BindingAdapter("app:show")
fun showTextView(v: View, b: Boolean) {
    v.isVisible = b
}

@BindingAdapter("app:onTextChange")
fun onTextChange(v: EditText, callbackWithText: CallbackWithText?) {
    v.doOnTextChanged { text, _, _, _ ->
        callbackWithText?.invoke(text.toString())
    }
}


@BindingAdapter("app:onClick")
fun onClick(b: Button, callback: Callback) {
    b.setOnClickListener { callback() }
}