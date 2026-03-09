package com.tc.kmp.tutorial.network

//https://jsonplaceholder.typicode.com/todos


interface TodopApiService {
    suspend fun getTodos() : Response<List<TodoDTO>>
}



