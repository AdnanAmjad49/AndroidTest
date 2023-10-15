package com.comcast.network.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.comcast.network.BuildConfig

object NetworkUtil {
    fun Context.isNetworkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                ?.let { capabilities ->
                    when {
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                } ?: false
        } else {
            try {
                connectivityManager.activeNetworkInfo?.isConnected == true
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
                false
            }
        }
    }
}