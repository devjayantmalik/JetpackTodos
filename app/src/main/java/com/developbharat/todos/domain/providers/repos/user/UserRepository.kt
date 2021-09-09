package com.developbharat.todos.domain.providers.repos.user

import com.developbharat.todos.domain.models.user.User
import com.developbharat.todos.domain.providers.IJSONPlaceholderAPI
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: IJSONPlaceholderAPI
): IUserRepository {
    override suspend fun getUsers(): List<User> {
        return api.getUsers().map { it.toUser() }
    }
}