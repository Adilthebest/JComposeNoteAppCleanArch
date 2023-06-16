package com.example.jetpackcomposenoteapp.feature_note.domain.model

data class Note(
    val title: String,
    val timestamp: String,
    val id:Int = DEFOULT_Id
):java.io.Serializable {
    companion object{
        const val DEFOULT_Id =0
    }
}

