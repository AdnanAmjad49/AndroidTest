package com.comcast.model

import com.google.gson.annotations.SerializedName

data class Taxonomy(

    @SerializedName("kingdom") var kingdom: String? = null,
    @SerializedName("phylum") var phylum: String? = null,
    @SerializedName("class") var className: String? = null,
    @SerializedName("order") var order: String? = null,
    @SerializedName("family") var family: String? = null,
    @SerializedName("genus") var genus: String? = null,
    @SerializedName("scientific_name") var scientificName: String? = null

)