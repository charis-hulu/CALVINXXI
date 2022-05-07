package com.example.calvinxxi
import com.squareup.moshi.Json

data class MovieResultData(
    @field:Json(name="id") val id : String,
    @field:Json(name="title") val title : String,
    @field:Json(name="genre") val genre : String,
    @field:Json(name="duration") val duration : Int,
    @field:Json(name="url_trailer") val url_trailer : String,
    @field:Json(name="synopsis") val synopsis : String,
    @field:Json(name="director") val director : String,
    @field:Json(name="cast") val cast : String,
    @field:Json(name="status") val status : Int,
    @field:Json(name="image") val image_url : String
)