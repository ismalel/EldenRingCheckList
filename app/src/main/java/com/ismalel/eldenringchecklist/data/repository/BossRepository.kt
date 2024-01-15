package com.ismalel.eldenringchecklist.data.repository

import com.ismalel.eldenringchecklist.data.model.BossData
import com.ismalel.eldenringchecklist.data.model.BossResponse
import kotlinx.coroutines.flow.Flow


fun interface BossRepository {
    suspend fun getBosses() : Flow<List<BossData>>
}