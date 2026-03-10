package com.tc.kmp.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tc.kmp.tutorial.db.getDatabaseBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App(getDatabaseBuilder(application).build())
        }
    }
}


/*
@Preview
@Composable
fun AppAndroidPreview() {
    App()
}*/
