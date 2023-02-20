package com.yrys.mykotlin5group48lesson1.data.base

import com.yrys.mykotlin5group48lesson1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        delay(1000)
        try {
            emit(Resource.Success(request()))
        } catch (ioException: IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)

}