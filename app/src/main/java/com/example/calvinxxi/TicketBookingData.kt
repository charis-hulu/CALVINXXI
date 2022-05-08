package com.example.calvinxxi

import com.squareup.moshi.Json

data class TicketBookingData(
    @field:Json(name="title") val title : String,
    @field:Json(name="duration") val duration : Int,
    @field:Json(name="image") val image_url : String,
    @field:Json(name="theatre_name") val theatre_name : String,
    @field:Json(name="schedule") val schedule : String,
    @field:Json(name="is_available") val is_available : Int
    )
