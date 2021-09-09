package com.developbharat.todos.screens.user.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developbharat.todos.common.Resource
import com.developbharat.todos.common.states.ErrorState
import com.developbharat.todos.common.states.LoadingState
import com.developbharat.todos.domain.uses.user.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
): ViewModel() {

    private val _state = mutableStateOf(UsersListState())
    val state: State<UsersListState> = _state

    init {
        loadAllUsers()
    }

    private fun loadAllUsers(){
        getUsersUseCase.execute().onEach { result ->
           when(result){
               is Resource.RequestSuccess -> {
                   _state.value = UsersListState(users = result.data ?: emptyList())
               }
               is Resource.RequestInProgress -> {
                   _state.value = UsersListState(loading = LoadingState(result.message))
               }
               is Resource.RequestError -> {
                   _state.value = UsersListState(error = ErrorState(result.message ?: "Unexpected error occurred."))
               }
           }
        }.launchIn(viewModelScope)
    }
}