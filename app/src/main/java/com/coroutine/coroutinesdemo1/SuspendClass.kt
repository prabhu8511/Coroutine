package com.coroutine.coroutinesdemo1

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main()= runBlocking {

println("main program starts: ${Thread.currentThread().name}")

    //start = CoroutineStart.LAZY  if we will not use result of coroutine, code inside the coroutine won't be executed
    val time = measureTimeMillis {
      val result:Deferred<String> = async(start = CoroutineStart.LAZY) {
          getMessageOne();
      }
      val result2:Deferred<String> = async (start = CoroutineStart.LAZY) {
          getMessageTwo();
      }
       println("Entire message is ${result.await() + result2.await()}")
       //println("Entire message is ${ result2.await()}")

    }

    println("completed in $time ms")

}

suspend fun getMessageOne():String{
    delay(1000L)
    println("function 1 executed")
    return "Hello"
}

suspend fun getMessageTwo():String{
    delay(1000L)
    println("function 2 executed")
    return "World"
}