package com.example.jetpackcomposenoteapp.feature_note.data.base

import com.example.jetpackcomposenoteapp.feature_note.domain.utils.Resourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository {

    protected  fun <T>  doReguest(reguest: suspend () -> T) = flow{
        emit(Resourse.Loading())
            try {
                val data =  reguest()
                emit(Resourse.Success(data))
            }catch (ioExaption:IOException){
                emit(Resourse.Error(ioExaption.localizedMessage ?: "hj"))
            }
        }.flowOn(Dispatchers.IO)
}