// src/main/java/com/example/prueba/MainActivity.kt
package com.example.prueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.prueba.ViewModel.PostViewModel
import com.example.prueba.ui.post.PostListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostApp()
        }
    }
}

@Composable
fun PostApp(viewModel: PostViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    Column {
        when (state) {
            is PostViewModel.UiState.Loading -> LoadingScreen()
            is PostViewModel.UiState.Success -> {
                PostListScreen(
                    posts = (state as PostViewModel.UiState.Success).posts,
                    onRefresh = { viewModel.refreshPosts() },
                    isRefreshing = isRefreshing
                )
            }
            is PostViewModel.UiState.Error -> ErrorScreen((state as PostViewModel.UiState.Error).message)
        }
    }
}


@Composable
fun LoadingScreen() {
    // Pantalla de carga con indicador circular
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: $message")
    }
}
