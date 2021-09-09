package com.developbharat.todos.domain.providers.repos.todo

import com.developbharat.todos.domain.models.todo.UserTodo
import com.developbharat.todos.domain.providers.IJSONPlaceholderAPI
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val api: IJSONPlaceholderAPI
): ITodoRepository {
    override suspend fun getUserTodos(userId: String): List<UserTodo> {
        return api.getUserTodos(userId).map { it.toUserTodo() }
    }
}