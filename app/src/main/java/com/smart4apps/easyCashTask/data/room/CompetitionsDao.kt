package com.smart4apps.easyCashTask.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smart4apps.easyCashTask.data.model.Competition
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionsDao {


    @Query("SELECT * FROM competitions")
    fun getAllCompetitions(): Flow<List<Competition>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompetitions(competitions: List<Competition>)
}