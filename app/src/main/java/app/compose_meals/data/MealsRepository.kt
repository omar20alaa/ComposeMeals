package app.compose_meals.data

import app.compose_meals.data.model.Category
import app.compose_meals.data.network.ApiService
import app.compose_meals.utils.NetworkConstants
import javax.inject.Inject

class MealsRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun getCategories(): List<Category> {
        return api.getCategories(NetworkConstants.API_KEY).categories
    }
}