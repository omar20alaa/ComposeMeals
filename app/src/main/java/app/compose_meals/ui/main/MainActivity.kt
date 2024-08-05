package app.compose_meals.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import app.compose_meals.ui.detail.CategoryDetailActivity
import app.compose_meals.ui.theme.ComposeMealsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMealsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategoryList(categoryList = viewmodel.categoryList, context = this) {
                        val intent =
                            Intent(this@MainActivity, CategoryDetailActivity::class.java).apply {
                                putExtra(CategoryDetailActivity.DETAIL_CATEGORY, it)
                            }
                        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                        startActivity(intent)
                    }
                    viewmodel.getCategories()
                }
            }
        }
    }
}

