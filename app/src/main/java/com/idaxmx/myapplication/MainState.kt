package com.idaxmx.myapplication

data class MainState(
    val list: List<User> = emptyList(),
    val filter: String = ""
) {
    fun updateFilter(filter: String) = copy(filter = filter)
    fun updateList(list: List<User>) = copy(list = list)
}