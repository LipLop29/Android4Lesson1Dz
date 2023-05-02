package com.example.android4lesson1dz.data.local.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {

    private val preference: SharedPreferences =
        context.getSharedPreferences("animeandmanga, preferences", Context.MODE_PRIVATE)

    operator fun invoke() = preference
}