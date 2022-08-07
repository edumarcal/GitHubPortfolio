package me.dio.githubportfolio.domain

import kotlinx.coroutines.flow.Flow
import me.dio.githubportfolio.core.UseCase
import me.dio.githubportfolio.data.model.Repository
import me.dio.githubportfolio.data.repositories.RepositoryList

class ListUserRepoUseCase(private val repository: RepositoryList): UseCase<String, List<Repository>>() {
    override suspend fun execute(param: String): Flow<List<Repository>> {
        return repository.listRepositories(param)
    }
}