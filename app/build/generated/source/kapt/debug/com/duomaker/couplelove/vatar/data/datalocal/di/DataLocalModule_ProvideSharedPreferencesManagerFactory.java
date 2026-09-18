package com.duomaker.couplelove.vatar.data.datalocal.di;

import android.content.SharedPreferences;
import com.duomaker.couplelove.vatar.core.helper.SharedPreferencesManager;
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
public final class DataLocalModule_ProvideSharedPreferencesManagerFactory implements Factory<SharedPreferencesManager> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<SharedPreferences.Editor> editorProvider;

  public DataLocalModule_ProvideSharedPreferencesManagerFactory(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<SharedPreferences.Editor> editorProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    this.editorProvider = editorProvider;
  }

  @Override
  public SharedPreferencesManager get() {
    return provideSharedPreferencesManager(sharedPreferencesProvider.get(), editorProvider.get());
  }

  public static DataLocalModule_ProvideSharedPreferencesManagerFactory create(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<SharedPreferences.Editor> editorProvider) {
    return new DataLocalModule_ProvideSharedPreferencesManagerFactory(sharedPreferencesProvider, editorProvider);
  }

  public static SharedPreferencesManager provideSharedPreferencesManager(
      SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
    return Preconditions.checkNotNullFromProvides(DataLocalModule.INSTANCE.provideSharedPreferencesManager(sharedPreferences, editor));
  }
}
