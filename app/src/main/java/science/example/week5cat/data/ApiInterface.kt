package science.example.week5cat.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

interface ApiInterface {

    suspend fun getCat(): List<Cat>
}


class CatService : ApiInterface {

    companion object {
        const val BASE_URL = "https://api.thecatapi.com/v1/images/search?limit=1"
    }

    private val client = HttpClient(CIO)
    private val json = Json { ignoreUnknownKeys = true }
    private var result: MutableList<Cat> = mutableListOf()

    override suspend fun getCat(): List<Cat> = withContext(Dispatchers.IO) {
        val response: HttpResponse = client.get(BASE_URL)

        result = json.decodeFromString(response.body())
        result
    }
}