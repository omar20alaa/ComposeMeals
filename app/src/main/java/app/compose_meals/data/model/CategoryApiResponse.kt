package app.compose_meals.data.model

import com.google.gson.annotations.SerializedName


data class CategoryApiResponse(
    @SerializedName("categories") val categories: List<Category>
)