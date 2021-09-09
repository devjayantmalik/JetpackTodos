package com.developbharat.todos.screens.todo.list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.developbharat.todos.domain.models.todo.UserTodo
import com.developbharat.todos.domain.models.user.User

@Composable
fun UserListItem(
    item: User,
    onItemClick: (User) -> Unit
) {
    Box(modifier = Modifier.padding(10.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(item) }
                .border(BorderStroke(5.dp, Color.Black)),
        ) {
            Text(
                text = "${item.id} ${item.name}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = item.email,
                style = MaterialTheme.typography.body2
            )
        }
    }
}
