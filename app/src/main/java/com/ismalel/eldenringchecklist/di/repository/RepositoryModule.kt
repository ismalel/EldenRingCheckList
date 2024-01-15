package com.ismalel.eldenringchecklist.di.repository

import com.ismalel.eldenringchecklist.data.api.ApiService
import com.ismalel.eldenringchecklist.data.repository.BossRepository
import com.ismalel.eldenringchecklist.data.repository.BossRepositoryImpl
import com.ismalel.eldenringchecklist.domain.GetBossesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        apiService: ApiService
    ): BossRepository {
        return BossRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideGetBossesUseCase(
        repository: BossRepository
    ): GetBossesUseCase {
        return GetBossesUseCase(repository)
    }
}