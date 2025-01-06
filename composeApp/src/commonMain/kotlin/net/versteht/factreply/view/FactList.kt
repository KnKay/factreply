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
import kotlinx.coroutines.runBlocking
import net.versteht.factreply.database.FactRepositoryJdbc
import org.koin.compose.koinInject

data class FactList(val category: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val myService = koinInject<FactRepositoryJdbc>()
        val facts = runBlocking{
            return@runBlocking myService.factsByCategory(category)
        }
        Scaffold (
            topBar = { TopAppBar(title = { Text("Facts for $category") }) },
            content = {
                    contentPadding ->
                Column(modifier = Modifier.padding(contentPadding)) {
                    for (fact in facts){
                        Button(onClick = {
                            // Navigate to details screen with the arguments
//                            navigator?.push(FactList(fact.))
                        }) {
                            Text(text = "Go to details of ${fact.answer}")
                        }
                    }

                }
            }
        )
    }
}