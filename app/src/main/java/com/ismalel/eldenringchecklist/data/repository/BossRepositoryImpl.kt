package com.ismalel.eldenringchecklist.data.repository

import com.ismalel.eldenringchecklist.data.api.ApiService
import com.ismalel.eldenringchecklist.data.model.BossData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class BossRepositoryImpl @Inject constructor(private val apiService: ApiService) : BossRepository {

    override suspend fun getBosses(): Flow<List<BossData>> {
        return flow {
            val response = apiService.getBosses()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(it.data)
                }
            }
        }
    }
}