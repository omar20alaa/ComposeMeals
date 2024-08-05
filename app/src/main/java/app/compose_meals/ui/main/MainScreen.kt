package app.compose_meals.ui.main

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.compose_meals.data.model.Category
import app.compose_meals.ui.theme.ComposeMealsTheme
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter


@Composable
fun CategoryItem(category: Category, context: Context, onClickListener: (Category) -> Unit) {

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(300.dp)
            .clickable { onClickListener.invoke(category) },
        shape = RoundedCornerShape(25.dp)
    ) {
        Surface(
            color = Color.LightGray
        ) {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = category.strThumb,
                        imageLoader = ImageLoader.Builder(context).crossfade(true).build()
                    ),
                    contentDescription = category.str,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = category.str,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = category.strDescription,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryList(
    categoryList: List<Category>,
    context: Context,
    onClickListener: (Category) -> Unit
) {
    LazyColumn {
        itemsIndexed(items = categoryList) { _, item ->
            CategoryItem(category = item, context, onClickListener)
        }
    }
}




