package com.developbharat.todos.screens.user.list

import com.developbharat.todos.common.states.ErrorState
import com.developbharat.todos.common.states.LoadingState
import com.developbharat.todos.domain.models.user.User

data class UsersListState(
    val loading: LoadingState = LoadingState(),
    val error: ErrorState = ErrorState(),
    val users: List<User> = emptyList()
)