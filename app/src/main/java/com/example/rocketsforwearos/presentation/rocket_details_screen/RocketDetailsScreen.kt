package com.example.rocketsforwearos.presentation.rocket_details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.rocketsforwearos.presentation.rocket_details_screen.view_model.RocketDetailsViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RocketDetailsScreen(
    viewModel: RocketDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        state.rocket?.let { rocketAndHeight ->
            ScalingLazyColumn(
                Modifier.padding(horizontal = 50.dp, vertical = 10.dp)
            ) {
                item {
                    Column {
                        Text(
                            text = rocketAndHeight.rocketEntity.rocketName,
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Row {
                            Text(
                                text = "Status: ",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Box(
                                modifier = Modifier
                                    .width(12.dp)
                                    .height(12.dp)
                                    .padding(top = 5.dp)
                                    .aspectRatio(1f)
                                    .background(
                                        if (rocketAndHeight.rocketEntity.isActive) Color.Green else Color.Red,
                                        shape = CircleShape
                                    )
                            ) {

                            }
                        }
                        Spacer(modifier = Modifier.height(21.dp))
                        GlideImage(
                            modifier = Modifier
                                .width(200.dp)
                                .height(100.dp)
                                .clip(RoundedCornerShape(5.dp)),
                            model = rocketAndHeight.rocketEntity.flickrImage,
                            contentDescription = "",
                            contentScale = ContentScale.Crop

                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = rocketAndHeight.rocketEntity.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }

}