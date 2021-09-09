package com.developbharat.todos.domain.providers.dto.todo

import com.developbharat.todos.domain.models.todo.UserTodo

data class TodoDTO(
    val id: Int,
    val completed: Boolean,
    val title: String,
    val userId: Int
){
    fun toUserTodo(): UserTodo {
        return UserTodo(
            id = "$id",
            title = title,
            completed = completed,
        )
    }
}