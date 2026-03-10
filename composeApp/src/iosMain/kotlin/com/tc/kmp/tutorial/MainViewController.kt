package com.tc.kmp.tutorial

import androidx.compose.ui.window.ComposeUIViewController
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.tc.kmp.tutorial.db.getDatabaseBuilder

fun MainViewController() = ComposeUIViewController { App( (getDatabaseBuilder().setDriver(BundledSQLiteDriver()).build())) }