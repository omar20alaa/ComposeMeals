package app.compose_meals.data.network

import app.compose_meals.data.model.CategoryApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(private val api: ApiClient) {

    suspend fun getCategories(apiKey: String): CategoryApiResponse {
        return withContext(Dispatchers.IO) {
            api.getCategories(apiKey)
        }
    }


}