package net.versteht.factreply

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import factreply.composeapp.generated.resources.Res
import factreply.composeapp.generated.resources.compose_multiplatform
import net.versteht.factreply.view.*
//import net.versteht.factreply.view.Category

@Composable
@Preview
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        TabNavigator(HomeScreen) {
            Scaffold(
                content = { paddingValues ->
                    Column(modifier = Modifier.padding(paddingValues)) {
                        CurrentTab()
                    }
                },
                bottomBar = {
                    BottomNavigation {
                        TabItem(HomeScreen)
                        TabItem(SettingsTab)
                    }
                }
            )
        }
    }
}