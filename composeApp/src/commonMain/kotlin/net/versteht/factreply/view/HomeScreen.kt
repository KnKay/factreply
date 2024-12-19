package net.versteht.factreply.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

// https://medium.com/@ahmedeelkhami/effortless-navigation-with-voyager-compose-multiplatform-development-145558b6247e
object HomeScreen : Screen {
    @Composable
    override fun Content(){
        val navigator = LocalNavigator.current
        Scaffold (
            topBar = {
                TopAppBar(title = { Text("Home") })
            },
            content = { contentPadding ->
                Column(modifier = Modifier.padding(contentPadding)) {
                    val items = listOf("Item 1", "Item 2", "Item 3")
                    items.forEach { item ->
                        Button(onClick = {
                            // Navigate to details screen with the arguments
                            navigator?.push(CategoryScreen(1))
                        }) {
                            Text(text = "Go to details of $item")
                        }
                    }
                }
            }
        )
    }
}