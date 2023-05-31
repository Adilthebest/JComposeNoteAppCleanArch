package com.example.jetpackcomposenoteapp.feature_note.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.feature_note.presentation.MainViewModel
import com.example.jetpackcomposenoteapp.feature_note.presentation.component.NoteItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(onNavigate: (NoteEntity?) -> Unit) {
    val vm: MainViewModel = koinViewModel()
    val state by vm.state.collectAsState()
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { onNavigate(null) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }) {
        LazyColumn() {
            items(state.todolist) { note ->
                NoteItem(
                    note = note,
                    onChecked ={ vm.update(note.id)},
                    onDelete ={vm.delete(it)},
                    onNavigation ={onNavigate(it)}
                )
            }
        }
    }
}