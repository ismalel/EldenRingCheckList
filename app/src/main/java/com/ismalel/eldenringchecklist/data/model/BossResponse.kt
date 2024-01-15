package com.ismalel.eldenringchecklist.data.model

data class BossResponse(
    val success: Boolean,
    val count: Long,
    val total: Long,
    val data: List<BossData>,
)
