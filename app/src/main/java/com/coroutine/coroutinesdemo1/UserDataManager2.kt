package com.coroutine.coroutinesdemo1

import kotlinx.coroutines.*

class UserDataManager2 {
    //structured concurrency

    var count = 0

    lateinit var deferred: Deferred<Int>

    suspend fun getTotalUserCount():Int{

        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000L)
                count = 50
            }

            deferred = async(Dispatchers.IO) {
                delay(3000L)
                return@async 70

            }
        }
        return count + deferred.await()

    }

}