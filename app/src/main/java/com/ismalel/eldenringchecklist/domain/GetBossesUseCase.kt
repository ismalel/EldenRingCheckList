package com.ismalel.eldenringchecklist.domain

import com.ismalel.eldenringchecklist.data.model.BossData
import com.ismalel.eldenringchecklist.data.repository.BossRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBossesUseCase @Inject constructor(
    private val repository: BossRepository
): BaseUseCase<Unit, Flow<List<BossData>>> {
    override suspend fun invoke(params: Unit): Flow<List<BossData>> {
        return repository.getBosses()
    }
}