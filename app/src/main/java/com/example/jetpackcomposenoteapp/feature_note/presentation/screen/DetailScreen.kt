package com.example.jetpackcomposenoteapp.feature_note.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.feature_note.presentation.utils.DetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    selected: Int,
    onNavigate: () -> Unit
) {
    val vm: DetailViewModel = koinViewModel()
    val state by vm.state.collectAsState()

    DetailScreenComponent(
        todoText = state.todo,
        onTodoTextChange ={vm.onTextChange(it)} ,
        timeText =state.time ,
        onTimeTextChange ={vm.onTimeChange(it)} ,
        onNavigate = {onNavigate() },
        onSaveTodo = {vm.insert(it)},
        selectedId =state.selectId
    )
}

@Composable
fun DetailScreenComponent(
    todoText: String,
    onTodoTextChange: (String) -> Unit,
    timeText: String,
    onTimeTextChange: (String) -> Unit,
    onNavigate: () -> Unit,
    onSaveTodo: (NoteEntity) -> Unit,
    selectedId: Int,
) {
    val isTodoEdit = selectedId == -14
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            value = todoText,
            onValueChange = { onTodoTextChange(it) },
            label = { Text(text = "Enter Note") })

        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            value = timeText,
            onValueChange = { onTimeTextChange(it) },
            label = { Text(text = "Enter Time") })
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = {
            val note = if (isTodoEdit) NoteEntity(todoText, timeText) else NoteEntity(
                todoText,
                timeText,
                id = selectedId
            )
            onSaveTodo(note)
            onNavigate()
        }) {
            val text = if (isTodoEdit) "Save Todo" else "Update Note"
            Text(text = text)
        }
    }
}