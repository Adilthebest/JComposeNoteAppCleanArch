package com.example.jetpackcomposenoteapp.feature_note.presentation.screen

import android.content.ClipData
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetpackcomposenoteapp.feature_note.domain.utils.UiState
import com.example.jetpackcomposenoteapp.feature_note.presentation.MainViewModel
import org.koin.androidx.compose.koinViewModel
import  androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.example.jetpackcomposenoteapp.Screens
import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import com.example.jetpackcomposenoteapp.feature_note.presentation.component.NoteItem
import com.example.jetpackcomposenoteapp.ui.theme.JetpackComposeNoteAppTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainScreen(
    navController: NavHostController
) {
    val vm: MainViewModel = koinViewModel()
    vm.getAllNotes()

    val getNote by vm.getAllNoteState.collectAsStateWithLifecycle()
    Column(modifier = Modifier.fillMaxSize()) {

        when (val state = getNote) {
            is UiState.Empty -> "empty"
            is UiState.Error -> "empty"
            is UiState.Loading -> "empty"
            is UiState.Success -> {
                LazyColumn {
                    items(state.data) { notes ->
                        NoteItem(notes)
                    }
                }
            }
        }
        Button(onClick = {
            navController.navigate(Screens.DetailScreen.route)
        }) {
            Text(
                text = "Add Note",
                color = Color.Black
            )
        }
    }
}

