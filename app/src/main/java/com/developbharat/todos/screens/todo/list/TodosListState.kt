package com.developbharat.todos.screens.todo.list

import com.developbharat.todos.common.states.ErrorState
import com.developbharat.todos.common.states.LoadingState
import com.developbharat.todos.domain.models.todo.UserTodo

data class TodosListState(
    val error: ErrorState = ErrorState(),
    val loading: LoadingState = LoadingState(),
    val todos: List<UserTodo> = emptyList()
)
