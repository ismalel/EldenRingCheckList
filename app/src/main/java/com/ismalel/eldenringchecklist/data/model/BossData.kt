package com.ismalel.eldenringchecklist.data.model

data class BossData(
    val id: String,
    val name: String,
    val image: String?,
    val region: String,
    val description: String,
    val location: String,
    val drops: List<String>,
    val healthPoints: String?
)
