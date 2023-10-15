package com.comcast.network.constant

object NetworkConstant {
    const val BASE_URL = "https://api.api-ninjas.com/v1/"
    const val MAX_CACHE_SIZE = 10 * 1024 * 1024 // 10 MB
    const val MAX_AGE_CACHE = 600
    const val MIN_AGE_CACHE = 5
    const val TIMEOUT = 30L
    const val CACHE_CONTROL = "Cache-Control"
    const val MAX_AGE = "max-age="
    const val MAX_STALE = "max-stale="
    const val CONTENT_TYPE = "Content-Type"
    const val CONTENT_TYPE_VALUE = "application/json"
    const val API_KEY = "X-Api-Key"
    const val CACHE_FILE_NAME = "http"
}