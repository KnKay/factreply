package net.versteht.factreply.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import factreply.composeapp.generated.resources.Res
import factreply.composeapp.generated.resources.compose_multiplatform
import net.versteht.factreply.Greeting
import org.jetbrains.compose.resources.painterResource

@Composable
fun Category() {
    val countries = listOf("Germany", "India", "Japan", "Brazil", "Australia")
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Category",
            )
            for (country in countries) {
                Text(
                    text = country,
                )
            }
        }
    }
}
