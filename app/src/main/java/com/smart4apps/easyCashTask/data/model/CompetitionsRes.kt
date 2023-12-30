package com.smart4apps.easyCashTask.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class CompetitionsRes(
    @SerializedName("count") val count: Long? = null,
    @SerializedName("filters") val filters: Map<String, Any>? = null,
    @SerializedName("competitions") val competitions: List<Competition>? = null,
)

@Parcelize
@Entity("competitions")
data class Competition(
    @PrimaryKey @SerializedName("id") val id: Long,
    @SerializedName("area") val area: Area? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("emblem") val emblem: String? = null,
    @SerializedName("plan") val plan: String? = null,
    @SerializedName("currentSeason") val currentSeason: CurrentSeason? = null,
    @SerializedName("numberOfAvailableSeasons") val numberOfAvailableSeasons: Long? = null,
    @SerializedName("lastUpdated") val lastUpdated: String? = null,
):Parcelable

@Parcelize
data class Area(
    @SerializedName("id") val id: Long? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("flag") val flag: String?? = null,
):Parcelable

@Parcelize
data class CurrentSeason(
    @SerializedName("id") val id: Long? = null,
    @SerializedName("startDate") val startDate: String? = null,
    @SerializedName("endDate") val endDate: String? = null,
    @SerializedName("currentMatchday") val currentMatchday: Long? = null,
    @SerializedName("winner") val winner: Winner? = null,
):Parcelable

@Parcelize
data class Winner(
    @SerializedName("id") val id: Long? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("shortName") val shortName: String? = null,
    @SerializedName("tla") val tla: String? = null,
    @SerializedName("crest") val crest: String? = null,
    @SerializedName("address") val address: String? = null,
    @SerializedName("website") val website: String? = null,
    @SerializedName("founded") val founded: Long? = null,
    @SerializedName("clubColors") val clubColors: String? = null,
    @SerializedName("venue") val venue: String? = null,
    @SerializedName("lastUpdated") val lastUpdated: String? = null,
):Parcelable
