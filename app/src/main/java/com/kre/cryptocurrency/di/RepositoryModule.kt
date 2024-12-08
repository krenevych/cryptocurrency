package com.kre.cryptocurrency.di

import com.kre.cryptocurrency.data.repository.RepositoryRemote
import com.kre.cryptocurrency.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsRepository(repository: RepositoryRemote) : Repository
}
