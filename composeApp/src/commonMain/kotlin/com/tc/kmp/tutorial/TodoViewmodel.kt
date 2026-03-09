package com.tc.kmp.tutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tc.kmp.tutorial.network.Response
import com.tc.kmp.tutorial.network.TodoApiServiceImpl
import com.tc.kmp.tutorial.network.TodoDTO
import com.tc.kmp.tutorial.network.TodoNetwork
import com.tc.kmp.tutorial.network.TodopApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


sealed class TodoScreenState{
    data object  Nothing  : TodoScreenState()
    data object  Loading  : TodoScreenState()
    data class Error(val msg   : String) :  TodoScreenState()
    data class Success(val todos : List<TodoDTO>) : TodoScreenState()
}

class TodoViewmodel(private val apiService: TodopApiService) : ViewModel() {


    private val _uiState = MutableStateFlow<TodoScreenState>(TodoScreenState.Nothing)
    val uiState get() = _uiState.asStateFlow()

    fun loadTodos(){
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                TodoScreenState.Loading
            }
            val response = apiService.getTodos()
            when(response){
                is Response.Error -> {
                    _uiState.update {
                        TodoScreenState.Error(response.msg)
                    }
                }
                is Response.Success<*> -> {
                    _uiState.update {
                        TodoScreenState.Success(response.result as List<TodoDTO>)
                    }
                }
            }
        }
    }
}

val todoModelFactory = viewModelFactory {
    initializer {
        TodoViewmodel(TodoApiServiceImpl(TodoNetwork.networkClient))
    }
}