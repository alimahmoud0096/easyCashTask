package com.smart4apps.easyCashTask.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.smart4apps.easyCashTask.data.model.Area
import com.smart4apps.easyCashTask.data.model.CurrentSeason

class Converters {
    @TypeConverter
    // Function to convert a model object to a JSON string
    fun areaToJsonString(model: Area?): String? {
        return Gson().toJson(model)
    }


    @TypeConverter
    // Function to convert a JSON string to a model object
    fun jsonStringToArea(jsonString: String?): Area? {
        return Gson().fromJson(jsonString, Area::class.java)
    }

    @TypeConverter
    // Function to convert a model object to a JSON string
    fun currentSeasonToJsonString(model: CurrentSeason?): String? {
        return Gson().toJson(model)
    }


    @TypeConverter
    // Function to convert a JSON string to a model object
    fun jsonStringToCurrentSeason(jsonString: String?): CurrentSeason? {
        return Gson().fromJson(jsonString, CurrentSeason::class.java)
    }
}
