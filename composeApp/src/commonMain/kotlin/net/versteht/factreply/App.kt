package net.versteht.factreply

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import net.versteht.factreply.di.appModule

import net.versteht.factreply.view.*
import org.koin.compose.KoinApplication


@Composable
fun App() {
    KoinApplication(
        application = {
            modules(appModule)
        }
    )
        {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            TabNavigator(HomeTab) {
                Scaffold(
                    content = {
                        CurrentTab()
                    },
                    bottomBar = {
                        BottomNavigation {
                            TabNavigationItem(HomeTab)
                            TabNavigationItem(SettingsTab)
                        }
                    }
                )
            }
        }
    }
}


@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
        val navigator = LocalTabNavigator.current

        BottomNavigationItem(
            selected = navigator.current == tab,
            onClick = { navigator.current = tab },
            icon = {
                tab.options.icon?.let {
                    Icon(
                        painter = it,
                        contentDescription = tab.options.title,
                    )
                }
            }
        )
    }
