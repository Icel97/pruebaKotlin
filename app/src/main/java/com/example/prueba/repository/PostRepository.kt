package com.example.prueba.repository

import com.example.prueba.model.Post
import com.example.prueba.network.RetrofitInstance

class PostRepository {
    private val api = RetrofitInstance.api

    suspend fun getPosts(): List<Post> {
        return api.getPosts()
    }
}

