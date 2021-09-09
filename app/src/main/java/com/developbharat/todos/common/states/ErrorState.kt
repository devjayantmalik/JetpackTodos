package com.developbharat.todos.common.states

data class ErrorState(
    private val message: String? = ""
){
    val isError = !message.isNullOrEmpty()
    val errorMessage: String = message ?: ""
}