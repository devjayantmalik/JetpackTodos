package com.developbharat.todos.domain.providers.repos.user

import com.developbharat.todos.domain.models.user.User


interface IUserRepository {
    suspend fun getUsers(): List<User>;
}