package com.developbharat.todos.di

import com.developbharat.todos.common.Constants
import com.developbharat.todos.domain.providers.IJSONPlaceholderAPI
import com.developbharat.todos.domain.providers.repos.todo.ITodoRepository
import com.developbharat.todos.domain.providers.repos.todo.TodoRepository
import com.developbharat.todos.domain.providers.repos.user.IUserRepository
import com.developbharat.todos.domain.providers.repos.user.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RootModule {
    @Provides
    @Singleton
    fun provideJSONPlaceholderAPI(): IJSONPlaceholderAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IJSONPlaceholderAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: IJSONPlaceholderAPI): IUserRepository {
        return UserRepository(api)
    }

    @Provides
    @Singleton
    fun provideTodoRepository(api: IJSONPlaceholderAPI): ITodoRepository {
        return TodoRepository(api)
    }
}