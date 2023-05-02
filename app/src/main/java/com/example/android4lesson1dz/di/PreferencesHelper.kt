package com.example.android4lesson1dz.di

import android.content.Context
import com.example.android4lesson1dz.data.local.preferences.PreferencesHelper
import com.example.android4lesson1dz.data.local.preferences.UserPreferencesData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PreferencesHelper {

    @Singleton
    @Provides
    fun provideSharadPreferences(
        @ApplicationContext context: Context
    ) = PreferencesHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferenceData(preferencesHelper: PreferencesHelper) =
        UserPreferencesData(preferencesHelper)
}