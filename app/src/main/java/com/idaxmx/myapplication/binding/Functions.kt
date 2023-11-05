package com.idaxmx.myapplication.binding

import com.idaxmx.myapplication.model.User

fun interface CallbackWithUser {
    operator fun invoke(user: User)
}

fun interface CallbackWithText {
    operator fun invoke(s: String)
}