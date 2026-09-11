package com.anime.oc.characters.avatar.data.datalocal.di;

import android.app.Application;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DataLocalModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
  private final Provider<Application> applicationProvider;

  public DataLocalModule_ProvideSharedPreferencesFactory(
      Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreferences(applicationProvider.get());
  }

  public static DataLocalModule_ProvideSharedPreferencesFactory create(
      Provider<Application> applicationProvider) {
    return new DataLocalModule_ProvideSharedPreferencesFactory(applicationProvider);
  }

  public static SharedPreferences provideSharedPreferences(Application application) {
    return Preconditions.checkNotNullFromProvides(DataLocalModule.INSTANCE.provideSharedPreferences(application));
  }
}
