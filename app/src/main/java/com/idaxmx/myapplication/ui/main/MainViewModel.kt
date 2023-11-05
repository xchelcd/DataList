package com.idaxmx.myapplication.ui.main

import androidx.lifecycle.ViewModel
import com.idaxmx.myapplication.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class MainViewModel(
    private val primaryList: List<User>
): ViewModel() {

    private var _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> get() = _state

    init {
        setList(primaryList)
    }

    private fun filterList() {
        val state = _state.value

        val newList = if (state.filter.isBlank()) primaryList
        else state.list.filter(::filter)
        setList(newList)
    }

    private fun filter(user: User): Boolean = user.name.startsWith(_state.value.filter, true)

    fun setFilter(filter: String) {
        _state.update {
            it.updateFilter(filter)
        }
        filterList()
    }

    private fun setList(list: List<User>) {
        _state.update {
            it.updateList(list)
        }
    }
}