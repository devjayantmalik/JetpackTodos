package com.developbharat.todos.domain.providers

import com.developbharat.todos.domain.providers.dto.todo.TodoDTO
import com.developbharat.todos.domain.providers.dto.user.UserDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IJSONPlaceholderAPI {
    @GET("/users")
    suspend fun getUsers(): List<UserDTO>

    @GET("/todos")
    suspend fun getUserTodos(@Query("userId") userId: String): List<TodoDTO>
}