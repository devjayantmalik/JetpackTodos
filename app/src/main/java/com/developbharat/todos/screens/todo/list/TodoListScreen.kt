package com.developbharat.todos.screens.todo.list

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
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.developbharat.todos.screens.todo.list.components.TodoListItem

@Composable
fun UserTodosListScreen(
    todoListViewModel: TodoListViewModel = hiltViewModel()
) {
    val state = todoListViewModel.state.value

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

        if(state.todos.isNotEmpty()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ){
                items(state.todos){ todo ->
                    TodoListItem(item = todo)
                }
            }
        }

    }
}