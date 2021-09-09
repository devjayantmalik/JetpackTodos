package com.developbharat.todos.screens.user.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.developbharat.todos.common.Constants
import com.developbharat.todos.common.Routes
import com.developbharat.todos.screens.todo.list.components.UserListItem

@Composable
fun UserListScreen(
    navController: NavController,
    usersListViewModel: UsersListViewModel = hiltViewModel()
) {
    val state = usersListViewModel.state.value;

    Box(modifier = Modifier.fillMaxSize()){
        if(state.loading.isLoading){
            Column {
                CircularProgressIndicator()
                Text(state.loading.status)
            }
        }

        if(state.error.isError){
            Text(state.error.errorMessage)
        }

        if(state.users.isNotEmpty()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ){
                items(state.users){ user ->
                    UserListItem(item = user, onItemClick = { item ->
                        navController.navigate(Routes.UserTodosListScreen.route + "/${item.id}")
                    })
                }
            }
        }

    }
}