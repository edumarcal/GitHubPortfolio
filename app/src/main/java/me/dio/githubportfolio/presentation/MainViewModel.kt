package me.dio.githubportfolio.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import me.dio.githubportfolio.data.model.Repository
import me.dio.githubportfolio.domain.ListUserRepoUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(private val listUserRepoUseCase: ListUserRepoUseCase): ViewModel() {
    private val _repositories = MutableLiveData<State>()
    val repositories: LiveData<State> = _repositories

    fun getListRepo(user: String) {
        viewModelScope.launch {
            listUserRepoUseCase(user)
                .onStart {
                    _repositories.postValue(State.Loading)
                }
                .catch {
                    _repositories.postValue(State.Error(it))
                }
                .collect {
                    _repositories.postValue(State.Success(it))
                }
        }
    }

    sealed class State {
        object Loading: State()
        data class Success(val list: List<Repository>): State()
        data class Error(val error: Throwable): State()
    }
}