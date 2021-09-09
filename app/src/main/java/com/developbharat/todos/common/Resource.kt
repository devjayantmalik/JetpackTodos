package com.developbharat.todos.common

sealed class Resource<T>(val data: T? = null, val message: String? = null){
    class RequestSuccess<T>(data: T): Resource<T>(data = data)
    class RequestError<T>(message: String, data: T? = null): Resource<T>(data, message)
    class RequestInProgress<T>(message: String? = null): Resource<T>(null, message);
}
