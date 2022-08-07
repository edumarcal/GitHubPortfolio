package me.dio.githubportfolio.data.repositories

import me.dio.githubportfolio.data.model.Repository
import kotlinx.coroutines.flow.Flow

interface RepositoryList {
    suspend fun listRepositories(user: String): Flow<List<Repository>>
}