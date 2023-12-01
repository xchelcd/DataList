package com.idaxmx.myapplication.model

import java.io.Serializable

data class User(
    val id: String,
    val name: String,
    val height: Float
) : Serializable