package com.smart4apps.easyCashTask.data.repository

import com.smart4apps.easyCashTask.data.api.ApiService
import com.smart4apps.easyCashTask.data.model.Competition
import com.smart4apps.easyCashTask.data.model.CompetitionsRes
import com.smart4apps.easyCashTask.data.room.CompetitionsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val competitionsDao: CompetitionsDao
) {

    fun getAllCompetitions(): Flow<List<Competition>> {
        return competitionsDao.getAllCompetitions()
    }


    suspend fun refreshCompetitions(): CompetitionsRes {
        return apiService.refreshCompetitions()
    }

    suspend fun insertCompetitions(competitions: List<Competition>) {
        competitionsDao.insertCompetitions(competitions)
    }


}