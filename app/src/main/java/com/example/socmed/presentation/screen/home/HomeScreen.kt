package com.example.socmed.presentation.screen.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val hasStory by remember { mutableStateOf(false) }

    Surface(modifier = modifier) {
        LazyRow(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            items(5) {
                AvatarContainer(hasStory)
            }
        }
    }
}

@Composable
fun AvatarContainer(hasStory: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .padding(6.dp)
                .then(
                    if (hasStory) {
                        Modifier
                            .border(
                                width = 3.dp,
                                color = Color.Gray,
                                shape = CircleShape
                            )
                    } else {
                        Modifier
                    }
                )
                .padding(4.dp)
                .size(80.dp)
        )
        {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                model = "https://static.vecteezy.com/system/resources/previews/004/819/327/non_2x/male-avatar-profile-icon-of-smiling-caucasian-man-vector.jpg",
                contentDescription = "Avatar Image",
                contentScale = ContentScale.Fit,
            )
        }
        Text("Username")
    }
}
