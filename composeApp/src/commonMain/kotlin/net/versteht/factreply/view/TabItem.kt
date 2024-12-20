package net.versteht.factreply.view

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text

@Composable
fun RowScope.TabItem(tab: Tab) {
    val navigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = navigator.current == tab,
        onClick = { navigator.current = tab },
        label = {
            Text(
                text = tab.options.title
            )
        },
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