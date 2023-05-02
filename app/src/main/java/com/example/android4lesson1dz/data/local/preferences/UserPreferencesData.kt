package com.example.android4lesson1dz.data.local.preferences

const val PREF_IS_AUTHORIZED = "isAuthorized"
const val PREF_ACCESS_TOKEN: String = "accessToken"
const val PREF_REFRESH_TOKEN: String = "refreshToken"

class UserPreferencesData(
    private val preference: PreferencesHelper
) {

    var isAuthorized: Boolean
        get() = preference().getBoolean(PREF_IS_AUTHORIZED, false)
        set(value) = preference().edit().putBoolean(PREF_IS_AUTHORIZED, value).apply()

    var accessToken: String
        get() = preference().getString(PREF_ACCESS_TOKEN, "null")!!
        set(value) = preference().edit().putString(PREF_ACCESS_TOKEN, value).apply()

    var refreshToken: String
        get() = preference().getString(PREF_REFRESH_TOKEN, "null")!!
        set(value) = preference().edit().putString(PREF_REFRESH_TOKEN, value).apply()
}