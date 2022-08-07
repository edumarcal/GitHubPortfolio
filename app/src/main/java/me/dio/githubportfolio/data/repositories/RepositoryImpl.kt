package me.dio.githubportfolio.data.repositories

import me.dio.githubportfolio.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import me.dio.githubportfolio.R
import me.dio.githubportfolio.core.RemoteException
import retrofit2.HttpException

class RepositoryImpl(private val service: GitHubService): RepositoryList {
    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: R.string.remote_exception.toString())
        }
    }
}