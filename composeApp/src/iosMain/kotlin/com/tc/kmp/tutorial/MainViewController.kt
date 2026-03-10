package com.tc.kmp.tutorial

import androidx.compose.ui.window.ComposeUIViewController
import com.tc.kmp.tutorial.db.getDatabaseBuilder

fun MainViewController() = ComposeUIViewController { App(getDatabaseBuilder().build()) }