package com.developbharat.todos.domain.providers.dto.user

import com.developbharat.todos.domain.models.user.User

data class UserDTO(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
){
    fun toUser(): User{
        return User(
            id = "$id",
            name = name,
            email = email,
            website = website
        )
    }
}