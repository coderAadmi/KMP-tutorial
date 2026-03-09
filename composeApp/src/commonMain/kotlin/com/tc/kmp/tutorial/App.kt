package com.tc.kmp.tutorial

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.painterResource

import tutorial.composeapp.generated.resources.Res
import tutorial.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        val todoViewmodel  =  viewModel<TodoViewmodel>(factory = todoModelFactory)
        val screenState by todoViewmodel.uiState.collectAsStateWithLifecycle()
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(getPlatformName())
            Button(onClick = { todoViewmodel.loadTodos()}) {
                Text("Click me!")
            }

            when(val state = screenState){
                is TodoScreenState.Error -> {
                    Text("Some Error Occured : ${state.msg}")
                }
                TodoScreenState.Loading -> {
                    Text("Fetching Todos.....")
                }
                TodoScreenState.Nothing -> {
                    Text("Click on load to fetch Todos")
                }
                is TodoScreenState.Success -> {
                    LazyColumn(Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(state.todos){ todo ->
                            Card(Modifier.fillMaxWidth()) {
                                Column(Modifier.fillMaxWidth().padding(12.dp)) {
                                    Text("Title ${todo.title}")
                                }
                            }
                        }
                    }
                }
            }


        }
    }
}