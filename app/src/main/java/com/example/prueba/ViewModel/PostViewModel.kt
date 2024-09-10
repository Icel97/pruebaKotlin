package com.example.prueba.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.prueba.model.Post
import com.example.prueba.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.delay

class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    sealed class UiState {
        object Loading : UiState()
        data class Success(val posts: List<Post>) : UiState()
        data class Error(val message: String) : UiState()
    }

    init {
        fetchPosts()
    }

    fun refreshPosts() {
        viewModelScope.launch {
            _isRefreshing.value = true
            delay(1000)
            try {
                val posts = repository.getPosts()
                _state.value = UiState.Success(posts)
            } catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Error desconocido")
            } finally {
                _isRefreshing.value = false
            }
        }
    }

    private fun fetchPosts(isRefreshing: Boolean = false) {
        viewModelScope.launch {
            try {
                if (isRefreshing) {
                    _isRefreshing.value = true
                }

                val posts = repository.getPosts()
                _state.value = UiState.Success(posts)
            } catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Error desconocido")
            } finally {
                if (isRefreshing) {
                    _isRefreshing.value = false
                }
            }
        }
    }
}
