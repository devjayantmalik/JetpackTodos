package com.developbharat.todos.domain.uses.user

import com.developbharat.todos.common.Resource
import com.developbharat.todos.domain.models.user.User
import com.developbharat.todos.domain.providers.repos.user.IUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetUsersUseCase @Inject constructor(
    private val repository: IUserRepository
) {
    fun execute(): Flow<Resource<List<User>>> = flow{
        try{
            emit(Resource.RequestInProgress<List<User>>("Retrieving Users from api..."))
            val users = repository.getUsers()
            emit(Resource.RequestSuccess<List<User>>(users))
        }catch(e: HttpException){
            // Server returned response code not starting with 200
            emit(Resource.RequestError<List<User>>(e.localizedMessage ?: "Request failed, It was invalid request."))
        }catch(e: IOException){
            // Server is not reachable, may be user is disconnected from internet.
            emit(Resource.RequestError<List<User>>("Connection to server failed. Please check your internet connection or retry after sometime."))
        }
    }
}