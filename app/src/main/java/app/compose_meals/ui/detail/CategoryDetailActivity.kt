package app.compose_meals.ui.detail

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import app.compose_meals.data.model.Category
import app.compose_meals.ui.main.CategoryItem
import app.compose_meals.ui.theme.ComposeMealsTheme
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable

@AndroidEntryPoint
class CategoryDetailActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(DETAIL_CATEGORY, Serializable::class.java) as Category
        } else {
            intent.getSerializableExtra(DETAIL_CATEGORY) as Category
        }

        setContent {
            ComposeMealsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategoryItem(category = category, context = this@CategoryDetailActivity)
                }
            }
        }

    }

    companion object {
        const val DETAIL_CATEGORY = "detail_category"
    }
}