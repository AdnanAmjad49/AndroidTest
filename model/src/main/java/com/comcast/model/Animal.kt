package com.comcast.model

import com.google.gson.annotations.SerializedName

data class Animal(
    @SerializedName("name") var name: String? = null,
    @SerializedName("taxonomy") var taxonomy: Taxonomy? = Taxonomy(),
    @SerializedName("locations") var locations: ArrayList<String> = arrayListOf(),
    @SerializedName("characteristics") var characteristics: Characteristics? = Characteristics(),
)