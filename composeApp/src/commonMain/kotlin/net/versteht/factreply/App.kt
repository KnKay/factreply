package net.versteht.factreply

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import net.versteht.factreply.database.CategoryTable
import net.versteht.factreply.database.*
import net.versteht.factreply.di.appModule

import net.versteht.factreply.view.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.compose.KoinApplication


@Composable
fun App() {
    Database.connect("jdbc:sqlite:./data.db", "org.sqlite.JDBC")
    transaction{
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(CategoryTable)
        SchemaUtils.create(FactTable)
        SchemaUtils.create(ThemeTable)
        try {
            CategoryTable.insert {
                it[name] = "Goodnews"
            }
            ThemeTable.insert {
                it[name] = "Energie"
            }

        }catch (e: Exception){
        }
        try {
            FactTable.insert {
                it[answer] = "god damn one"
                it[sourceLink] = "internet"
                it[category] = 1
                it[theme] = 1
            }
        } catch (e: Exception){
        }

    }
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
