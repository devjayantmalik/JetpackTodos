package com.developbharat.todos.domain.uses.todo

import com.developbharat.todos.common.Resource
import com.developbharat.todos.domain.models.todo.UserTodo
import com.developbharat.todos.domain.providers.repos.todo.ITodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserTodosUseCase @Inject constructor(
    private  val repository: ITodoRepository
) {
    fun execute(userId: String): Flow<Resource<List<UserTodo>>> = flow{
        try{
            emit(Resource.RequestInProgress("Fetching user todos..."))
            val todos = repository.getUserTodos(userId)
            emit(Resource.RequestSuccess(todos))
        }catch(e: HttpException){
            // Server returned response code not starting with 200
            emit(Resource.RequestError<List<UserTodo>>(e.localizedMessage ?: "Request failed, It was invalid request."))
        }catch(e: IOException){
            // Server is not reachable, may be user is disconnected from internet.
            emit(Resource.RequestError<List<UserTodo>>("Connection to server failed. Please check your internet connection or retry after sometime."))
        }
    }
}