package app.compose_meals.domain

import app.compose_meals.data.MealsRepository
import app.compose_meals.data.model.Category
import javax.inject.Inject


class CategoryUseCase @Inject constructor(private val repository: MealsRepository) {

    suspend operator fun invoke() : List<Category> = repository.getCategories()

}
