package com.example.jetpackcomposenoteapp.feature_note.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import java.util.Locale

@Composable
fun NoteItem(
    note: NoteEntity,
    onChecked: (Boolean) -> Unit,
    onDelete: (NoteEntity) -> Unit,
    onNavigation: (NoteEntity) -> Unit,
) {

    Card(
        backgroundColor = MaterialTheme.colors. primaryVariant,
        modifier = Modifier
            .padding(16.dp)
            .clickable { onNavigation(note) },
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
Checkbox(checked = note.isComplete , onCheckedChange ={onChecked(it)} )
            Column(modifier = Modifier.weight(1f)) {
                Text(text = note.title, style = MaterialTheme.typography.subtitle2  )
CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
    Text(text = note.timestamp, style = MaterialTheme.typography.subtitle2  )

}
            }
            IconButton(onClick= {onDelete(note)}){
                Icon(imageVector = Icons.Default.Clear, contentDescription =null )
            }
        }
    }

}