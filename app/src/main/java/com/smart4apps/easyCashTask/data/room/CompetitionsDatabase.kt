package com.smart4apps.easyCashTask.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.smart4apps.easyCashTask.data.model.Competition
import com.smart4apps.easyCashTask.utils.Converters

@Database(entities = [Competition::class], version = 4)
@TypeConverters(Converters::class)
abstract class CompetitionsDatabase : RoomDatabase() {

    abstract fun competitionsDao(): CompetitionsDao

}