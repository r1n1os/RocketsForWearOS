package com.example.rocketsforwearos.presentation.rockets_list_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rocketsforwearos.data.local_database.entities.relations.RocketAndHeight

@Composable
fun RocketListItem(
    rocketAndHeight: RocketAndHeight,
    onRocketClick: (RocketAndHeight) -> Unit
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { onRocketClick(rocketAndHeight) }
        .padding(start = 30.dp, end = 30.dp, top = 20.dp),) {
        Text(
            text = rocketAndHeight.rocketEntity.rocketName,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${rocketAndHeight.rocketEntity.company} (${rocketAndHeight.rocketEntity.country})",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (rocketAndHeight.rocketEntity.isActive) "Active" else "Inactive",
            color = if (rocketAndHeight.rocketEntity.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis
        )
    }
}
