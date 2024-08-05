package app.compose_meals.data.network

import app.compose_meals.data.model.CategoryApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("{api_key}/categories.php")
    suspend fun getCategories(@Path("api_key") apiKey: String) : CategoryApiResponse

}