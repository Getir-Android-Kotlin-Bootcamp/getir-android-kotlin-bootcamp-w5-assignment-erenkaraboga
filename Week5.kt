import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.net.URL


fun main() {

    /*
      //Page Number  6
      CoroutineScope(IO).launch {
          delay(10000)
          println("Coroutine completed")
      }
  */

    /*

        //Page Number  7
        val deferred = GlobalScope.async {
            "Hello"
        }
        runBlocking {
            val message = deferred.await()
            println(message)
        }
    */

    /*
        //Page Number  8
        runBlocking {
            delay(5000)
            println("Coroutine completed")
        }
    */


    /*

        //Page Number  9
        CoroutineScope(Dispatchers.Main).launch {
            val text = "ui updated!"
        }

    */

    /*

        //Page Number  10
        CoroutineScope(IO).launch {
            val url = "https://example.com/api/data"
            val response = URL(url).readText()
            println(response)
        }
    */

    /*
        //Page Number  11
        CoroutineScope(Dispatchers.Default).launch {
            var sum = 0
            for (i in 0..100000) {
                sum += i
            }
            println("Total : $sum")
        }
    */

    /*
        //Page Number  12
        val url = "https://api.example.com/data"

        CoroutineScope(IO).launch {
            withContext(Dispatchers.IO) {
                val response = URL(url).readText()
                println("Data: $response")
            }
        }


        val scope = CoroutineScope(IO)
        fun myCoroutine(job: Job) {
            scope.launch {
                withContext(job) {}
            }
        }
    */


    /*
        //Page Number  13
        val scope = CoroutineScope(IO)

        val job = Job()

        scope.launch(job) {}

        job.cancel()
    */


    /*
        //Page Number  15
        fun getNumbers(delay: Long): List<Int> {
            val numbers = mutableListOf<Int>()
            for (i in 1..10) {
                Thread.sleep(delay)
                numbers.add(i)
            }
            return numbers
        }

        fun main() {
            val numbers = getNumbers(100)
            for (number in numbers) {
                println(number)
            } }
     */


    /*
        //Page Number  16
        fun getNumbersFlow(delay: Long): Flow<Int> {
            return flow {
                for (i in 1..10) {
                    emit(i)
                    delay(delay)
                }
            }
        }

        fun main() {
            val flow = getNumbersFlow(100)
            launch {
                for (number in flow) {
                    println(number)
                }
            }
        }
     */


    /*
        //Page Number  17
        val scope = CoroutineScope(IO)

        scope.launch {
        }
     */


    /*
        //Page Number  18
        val supervisorJob = SupervisorJob()
        val scope = CoroutineScope(supervisorJob)

        scope.launch {
        }

        scope.launch {
        }
     */


    /*
        //Page Number  19
        val unSupervisedJob = SupervisorJob()
        val scope = CoroutineScope(unSupervisedJob)
        scope.launch {}
        scope.launch {}
     */


    /*
        //Page Number  20
        val uiScope = MainCoroutineScope()
        uiScope.launch {}
     */


    /*
        //Page Number  21
        val supervisorScope = SupervisorScope()
        supervisorScope.launch {}
    */


    /*
        //Page Number  23
        val flow = flow {
            emit(1)
            emit(2)
            emit(3)
        }
        flow.collect { value -> println(value) }
     */


    /*
        //Page Number  24
        val numbers = listOf(1, 2, 3)
        val flow = numbers.asFlow()
        flow.collect { value -> println(value) }
     */


    /*
        //Page Number  25
        val numbersFlow = flow {
            emit(1)
            emit(2)
            emit(3)
        }
        val squaresFlow = numbersFlow.map { number -> number * number }
        squaresFlow.collect { square -> println(square) }
    */


    /*
        //Page Number  26
        val numbersFlow = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
            emit(5)
        }
        val oddsFlow = numbersFlow.filter { number -> number % 2 == 1 }
        oddsFlow.collect { odd -> println(odd) }
    */


    /*
        //Page Number  27
        suspend fun performRequest(request: Int): String {
            delay(1000)
            return "response $request"
        }
        fun main() = runBlocking<Unit> {
            (1..3).asFlow()
                .transform { request ->
                    emit("Making request $request")
                    emit(performRequest(request))
                }
                .collect { response -> println(response) }
        }
     */


    /*
        //Page Number  28
        val numbersFlow = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
            emit(5)
        }
        numbersFlow
            .flowOn(Dispatchers.IO)
            .collect { number -> println(number) }
     */


    /*
        //Page Number  31
        fun main() = runBlocking {
            val channel = Channel<Int>()

            launch {
                println("Sender started")
                channel.send(10)
                println("Value sent: 10")
            }

            launch {
                println("Receiver started")
                val value = channel.receive()
                println("Value received: $value")
            }
        }
     */


    /*
        //Page Number  32
        fun main() = runBlocking {
            val channel = Channel<String>()

            launch {
                println("Sender started")
                for (i in 1..5) {
                    channel.send("Message $i")
                    println("Message sent: Message $i")
                }
            }

            launch {
                println("Receiver started")
                while (true) {
                    val message = channel.receive()
                    println("Message received: $message")
                }
            }
        }
     */


    /*
        //Page Number  33
        fun main() = runBlocking {
            val tickerChannel = ticker(1000, 0)
            launch {
                println("Receiver started")
                while (true) {
                    tickerChannel.receive()
                    println("Click received")
                }
            }
            delay(5000)
        }
    */

}