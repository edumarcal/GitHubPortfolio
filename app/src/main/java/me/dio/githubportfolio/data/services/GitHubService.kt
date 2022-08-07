package me.dio.githubportfolio.data.services

import me.dio.githubportfolio.data.model.Repository
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") user: String) : List<Repository>
}