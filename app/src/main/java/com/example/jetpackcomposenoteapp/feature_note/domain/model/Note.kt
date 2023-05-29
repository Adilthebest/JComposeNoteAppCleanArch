package com.example.jetpackcomposenoteapp.feature_note.domain.model

data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    val id:Int? = DEFOULT_Id
):java.io.Serializable {
    companion object{
        const val DEFOULT_Id =0
    }
}

