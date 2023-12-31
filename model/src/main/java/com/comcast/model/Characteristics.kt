package com.comcast.model

import com.google.gson.annotations.SerializedName

data class Characteristics(
    @SerializedName("prey") var prey: String? = null,
    @SerializedName("name_of_young") var nameOfYoung: String? = null,
    @SerializedName("group_behavior") var groupBehavior: String? = null,
    @SerializedName("estimated_population_size") var estimatedPopulationSize: String? = null,
    @SerializedName("biggest_threat") var biggestThreat: String? = null,
    @SerializedName("most_distinctive_feature") var mostDistinctiveFeature: String? = null,
    @SerializedName("other_name(s)") var otherNames: String? = null,
    @SerializedName("gestation_period") var gestationPeriod: String? = null,
    @SerializedName("habitat") var habitat: String? = null,
    @SerializedName("predators") var predators: String? = null,
    @SerializedName("diet") var diet: String? = null,
    @SerializedName("average_litter_size") var averageLitterSize: String? = null,
    @SerializedName("lifestyle") var lifestyle: String? = null,
    @SerializedName("common_name") var commonName: String? = null,
    @SerializedName("number_of_species") var numberOfSpecies: String? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("slogan") var slogan: String? = null,
    @SerializedName("group") var group: String? = null,
    @SerializedName("color") var color: String? = null,
    @SerializedName("skin_type") var skinType: String? = null,
    @SerializedName("top_speed") var topSpeed: String? = null,
    @SerializedName("lifespan") var lifespan: String? = null,
    @SerializedName("weight") var weight: String? = null,
    @SerializedName("length") var length: String? = null,
    @SerializedName("age_of_sexual_maturity") var ageOfSexualMaturity: String? = null,
    @SerializedName("age_of_weaning") var ageOfWeaning: String? = null,
    @SerializedName("wingspan") var wingspan: String? = null,
)