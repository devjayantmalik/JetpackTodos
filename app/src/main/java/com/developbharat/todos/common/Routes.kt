package com.developbharat.todos.common

sealed class Routes(val route: String){
    object UsersListScreen: Routes("users_list_screen")
    object UserTodosListScreen: Routes("user_todos_list_screen")
}
