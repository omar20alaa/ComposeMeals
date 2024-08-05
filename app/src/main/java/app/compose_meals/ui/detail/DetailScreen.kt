package app.compose_meals.ui.detail

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.compose_meals.data.model.Category
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryItem(category: Category, context: Context) {

    Surface(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxHeight(),
        color = Color.White,
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = category.str,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 25.dp)
            )

            Image(
                painter = rememberAsyncImagePainter(
                    model = category.strThumb,
                    imageLoader = ImageLoader.Builder(context).crossfade(true).build()
                ),
                contentDescription = category.str,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
            )
            Text(
                text = category.strDescription,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(25.dp)
            )
        }
    }

}