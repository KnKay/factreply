package net.versteht.factreply

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import net.versteht.factreply.di.appModule


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "FactReply",
    ) {
        App()
    }
}