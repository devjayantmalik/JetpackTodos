package com.developbharat.todos.common.states

data class LoadingState(
    private val message: String? = "",
    private val loading: Boolean = false
){
    val isLoading = loading || !message.isNullOrEmpty();
    val status: String = message ?: "";
}