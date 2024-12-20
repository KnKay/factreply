package net.versteht.factreply.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.LocalNavigator

import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.*
import org.jetbrains.compose.resources.*

// https://medium.com/@ahmedeelkhami/effortless-navigation-with-voyager-compose-multiplatform-development-145558b6247e
object HomeScreen : Tab {
    @Composable
    override fun Content(){
        val navigator = LocalNavigator.current
        Scaffold (
            topBar = {
                TopAppBar(title = { Text("Home") })
            },
            content = { contentPadding ->
                Column(modifier = Modifier.padding(contentPadding)) {
                    Text(text = "Home Screen Thingy")
                }
            }
        )
    }

    override val options: TabOptions
        @Composable
        get() {

            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Home",
                    icon = icon
                )
            }
        }
}