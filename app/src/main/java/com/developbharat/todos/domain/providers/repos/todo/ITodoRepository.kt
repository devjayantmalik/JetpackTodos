package com.developbharat.todos.domain.providers.repos.todo

import com.developbharat.todos.domain.models.todo.UserTodo


interface ITodoRepository {
    suspend fun getUserTodos(userId: String): List<UserTodo>
}