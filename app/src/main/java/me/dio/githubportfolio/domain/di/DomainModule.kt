package me.dio.githubportfolio.domain.di

import me.dio.githubportfolio.domain.ListUserRepoUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule(): Module {
        return module {
            factory { ListUserRepoUseCase(get()) }
        }
    }
}