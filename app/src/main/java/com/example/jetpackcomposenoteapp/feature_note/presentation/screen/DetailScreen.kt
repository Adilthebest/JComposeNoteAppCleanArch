package com.example.jetpackcomposenoteapp.feature_note.presentation.screen

import android.content.Context
import android.graphics.fonts.FontStyle
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcomposenoteapp.Screens
import org.koin.androidx.compose.koinViewModel
import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import com.example.jetpackcomposenoteapp.feature_note.domain.utils.UiState
import com.example.jetpackcomposenoteapp.feature_note.presentation.MainViewModel
import com.example.jetpackcomposenoteapp.ui.theme.JetpackComposeNoteAppTheme

@Composable
fun DetailScreen(
    ClicksListener:() -> Unit) {
    val vm: MainViewModel = koinViewModel()
    var text  =  remember {
        mutableStateOf("")
    }
    var desc  = remember {
        mutableStateOf("")
    }
    val create  by vm.createNoteState.collectAsState()

    JetpackComposeNoteAppTheme {


        val onClick: () -> Unit = {
            val note = Note(timestamp = text.value, title = desc.value)
            vm.createNote(note)
            ClicksListener.invoke()
        }
when(val state = create){
    is UiState.Empty -> "empty"
    is UiState.Error -> "empty"
    is UiState.Loading -> "empty"
    is UiState.Success -> {

        Log.e("ololo", "DetailScreen:${state.data} ", )
    }
}

        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                label = { Text(text = "Enter Time") })

            OutlinedTextField(
                value = desc.value,
                onValueChange = { desc.value = it },
                label = { Text(text = "Enter Time") })

            Button(onClick = {
                onClick.invoke()
            }) {
                Text(text = "Send", fontSize = 24.sp)
            }
        }
    }

}