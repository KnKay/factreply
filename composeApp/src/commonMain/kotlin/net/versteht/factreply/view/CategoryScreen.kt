package net.versteht.factreply.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

val countries = listOf("Germany", "India", "Japan", "Brazil", "Australia")

class CategoryListScreen : Screen {

    @Composable
    override fun Content(){
        MaterialTheme {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Category ",
                )
                for (country in countries) {
                    Text(
                        text = country,
                    )
                }
            }
        }
    }
}

class CategoryScreen(val categoryId: Int) : Screen {
    @Composable
    override fun Content(){
        val country = countries[categoryId]
        val navigator = LocalNavigator.current
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Detail") })
            },
            content = { contentPadding ->
                Column(modifier = Modifier.padding(contentPadding)) {
                    Text(text = "Details of $country")
                    Button(onClick = {
                        navigator?.pop()
                    }) {
                        Text(text = "Back")
                    }
                }
            }
        )
    }
}