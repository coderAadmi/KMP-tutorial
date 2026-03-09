package com.tc.kmp.tutorial.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.http.ContentType

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class TodoApiServiceImpl(private val client : HttpClient) : TodopApiService{

    override suspend fun getTodos(): Response<List<TodoDTO>> {
        try {
            val todos = client.get("${BASE_URL}todos"){
                accept(ContentType.Application.Json)
            }
            return Response.Success(todos.body() )
        }
        catch (e : Exception){
            return Response.Error(e.message.toString())
        }
    }
}