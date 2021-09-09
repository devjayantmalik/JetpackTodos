package com.developbharat.todos.domain.providers.dto.user

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)