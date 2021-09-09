package com.developbharat.todos.screens.todo.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developbharat.todos.common.Constants
import com.developbharat.todos.common.Resource
import com.developbharat.todos.common.states.ErrorState
import com.developbharat.todos.common.states.LoadingState
import com.developbharat.todos.domain.uses.todo.GetUserTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val getUserTodosUseCase: GetUserTodosUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(TodosListState())
    val state: State<TodosListState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_USER_TODOS_USER_ID)?.let { userId ->
            loadAllUserTodos(userId)
        }
    }

    private fun loadAllUserTodos(userId: String){
        getUserTodosUseCase.execute(userId).onEach { result ->
            when(result){
                is Resource.RequestSuccess -> {
                    _state.value = TodosListState(todos = result.data?: emptyList())
                }
                is Resource.RequestInProgress -> {
                    _state.value = TodosListState(loading = LoadingState(result.message))
                }
                is Resource.RequestError -> {
                    _state.value = TodosListState(error = ErrorState(result.message))
                }
            }
        }.launchIn(viewModelScope)
    }

}