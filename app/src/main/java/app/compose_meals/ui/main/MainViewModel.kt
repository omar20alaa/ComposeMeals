package app.compose_meals.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.compose_meals.data.model.Category
import app.compose_meals.domain.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: CategoryUseCase) : ViewModel() {

    var categoryList: List<Category> by mutableStateOf(listOf())

    fun getCategories() {
        viewModelScope.launch {
            categoryList = useCase.invoke()
        }
    }

}