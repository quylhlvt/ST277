package com.anime.oc.characters.avatar.data.datalocal.di;

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
public final class DataLocalModule_ProvideSharedPreferencesEditorFactory implements Factory<SharedPreferences.Editor> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public DataLocalModule_ProvideSharedPreferencesEditorFactory(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public SharedPreferences.Editor get() {
    return provideSharedPreferencesEditor(sharedPreferencesProvider.get());
  }

  public static DataLocalModule_ProvideSharedPreferencesEditorFactory create(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new DataLocalModule_ProvideSharedPreferencesEditorFactory(sharedPreferencesProvider);
  }

  public static SharedPreferences.Editor provideSharedPreferencesEditor(
      SharedPreferences sharedPreferences) {
    return Preconditions.checkNotNullFromProvides(DataLocalModule.INSTANCE.provideSharedPreferencesEditor(sharedPreferences));
  }
}
