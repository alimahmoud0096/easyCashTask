package com.smart4apps.easyCashTask.data.api

import com.smart4apps.easyCashTask.data.model.CompetitionsRes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("competitions")
    suspend  fun refreshCompetitions(): CompetitionsRes
}