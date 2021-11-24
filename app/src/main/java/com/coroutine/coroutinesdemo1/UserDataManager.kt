package com.coroutine.coroutinesdemo1

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManager {
    //unstructured concurrency
    suspend fun getTotalUserCount():Int{
        var count = 0
         CoroutineScope(IO).launch {
            delay(1000L)
            count = 50
        }

        val deferred = CoroutineScope(IO).async {
            delay(3000L)
            return@async 70

        }



        return count + deferred.await()

    }
}