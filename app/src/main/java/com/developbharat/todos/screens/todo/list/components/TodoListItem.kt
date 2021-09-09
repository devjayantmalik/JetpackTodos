package com.developbharat.todos.screens.todo.list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.developbharat.todos.domain.models.todo.UserTodo

@Composable
fun TodoListItem(
    item: UserTodo,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(1f)
        .padding(5.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .border(BorderStroke(2.dp, Color.Green)),
        ) {
            Text(
                text = "${item.id} ${item.title}",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = if (item.completed) "done" else "pending",
                color = if (item.completed) Color.Green else Color.Red,
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}