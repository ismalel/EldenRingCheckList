package com.ismalel.eldenringchecklist.data.api

import com.ismalel.eldenringchecklist.data.model.BossResponse
import retrofit2.Response
import retrofit2.http.GET

fun interface ApiService {

    @GET("api/bosses")
    suspend fun getBosses(): Response<BossResponse>
}