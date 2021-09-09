package com.developbharat.todos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developbharat.todos.common.Constants
import com.developbharat.todos.common.Routes
import com.developbharat.todos.screens.todo.list.UserTodosListScreen
import com.developbharat.todos.screens.user.list.UserListScreen
import com.developbharat.todos.ui.theme.TodosTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodosTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.UsersListScreen.route){
                        composable(route = Routes.UsersListScreen.route){
                            UserListScreen(navController = navController )
                        }
                        composable(route = Routes.UserTodosListScreen.route + "/{${Constants.PARAM_USER_TODOS_USER_ID}}"){
                            UserTodosListScreen()
                        }
                    }
                }
            }
        }
    }
}
