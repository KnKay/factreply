package net.versteht.factreply.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import net.versteht.factreply.database.CategoryRepositoryJdbc
import net.versteht.factreply.model.CategoryRepository
import org.koin.compose.koinInject

val countries = listOf("Germany", "India", "Japan", "Brazil", "Australia")
//https://insert-koin.io/docs/reference/koin-compose/compose/
class CategoryListScreen : Screen {


    @Composable
    override fun Content(){
        val navigator = LocalNavigator.current
        val myService = koinInject<CategoryRepositoryJdbc>()
        Scaffold (
            topBar = { TopAppBar(title = { Text("Categories") }) },
            content = {
                contentPadding ->
                    Column(modifier = Modifier.padding(contentPadding)) {
                        for ((index, value )in countries.iterator().withIndex()){
                            Button(onClick = {
                                // Navigate to details screen with the arguments
                                navigator?.push(CategoryDetailScreen(index))
                            }) {
                                Text(text = "Go to details of $value")
                            }
                        }
                    }
            }
        )
    }
}

data class CategoryDetailScreen(val item: Int) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val name = countries[item]
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Detail") })
            },
            content = { contentPadding ->
                Column(modifier = Modifier.padding(contentPadding)) {
                    Text(text = "Details of $name")
                    Button(onClick = {
                        // Pop to backstack
                        navigator?.pop()
                    }) {
                        Text(text = "Back to Home")
                    }
                }
            }
        )
    }
}