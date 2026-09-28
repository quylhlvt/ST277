package com.warrior.oc.ca.data.datalocal.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.warrior.oc.ca.core.helper.PermissionDenialStore
import com.warrior.oc.ca.core.helper.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataLocalModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences =
        application.getSharedPreferences("DEFAULT", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideSharedPreferencesManager(
        sharedPreferences: SharedPreferences
    ): SharedPreferencesManager =
        SharedPreferencesManager.apply {
            this.sharedPreferences = sharedPreferences
        }

    @Provides
    @Singleton
    fun providePermissionDenialStore(
        preferences: SharedPreferencesManager
    ): PermissionDenialStore = object : PermissionDenialStore {
        override fun storageDenials(): Int = preferences.isPermissionStorRequest()
        override fun setStorageDenials(count: Int) = preferences.setPermissionStorRequest(count)
        override fun notificationDenials(): Int = preferences.isPermissionNotiRequest()
        override fun setNotificationDenials(count: Int) = preferences.setPermissionNotiRequest(count)
        override fun cameraDenials(): Int = preferences.isPermissionCamRequest()
        override fun setCameraDenials(count: Int) = preferences.setPermissionCamRequest(count)
    }
}
