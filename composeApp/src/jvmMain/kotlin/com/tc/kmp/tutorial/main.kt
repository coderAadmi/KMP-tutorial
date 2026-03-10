package com.tc.kmp.tutorial

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.tc.kmp.tutorial.db.getDatabaseBuilder

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Tutorial",
        state = rememberWindowState(size = DpSize(600.dp, 800.dp))
    ) {
        App( (getDatabaseBuilder().setDriver(BundledSQLiteDriver()).build()) )
    }
}