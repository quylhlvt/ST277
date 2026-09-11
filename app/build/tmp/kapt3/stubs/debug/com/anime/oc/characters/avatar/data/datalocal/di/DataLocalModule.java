package com.anime.oc.characters.avatar.data.datalocal.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0010H\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/anime/oc/characters/avatar/data/datalocal/di/DataLocalModule;", "", "()V", "provideNetworkFlow", "Lkotlinx/coroutines/flow/Flow;", "", "networkMonitor", "Lcom/anime/oc/characters/avatar/core/helper/NetworkMonitor;", "provideNetworkMonitor", "context", "Landroid/content/Context;", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "application", "Landroid/app/Application;", "provideSharedPreferencesEditor", "Landroid/content/SharedPreferences$Editor;", "sharedPreferences", "provideSharedPreferencesManager", "Lcom/anime/oc/characters/avatar/core/helper/SharedPreferencesManager;", "editor", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DataLocalModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.anime.oc.characters.avatar.data.datalocal.di.DataLocalModule INSTANCE = null;
    
    private DataLocalModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences provideSharedPreferences(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences.Editor provideSharedPreferencesEditor(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.anime.oc.characters.avatar.core.helper.SharedPreferencesManager provideSharedPreferencesManager(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences.Editor editor) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.anime.oc.characters.avatar.core.helper.NetworkMonitor provideNetworkMonitor(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> provideNetworkFlow(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.core.helper.NetworkMonitor networkMonitor) {
        return null;
    }
}