package com.duomaker.couplelove.vatar.ui.language;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class LanguageViewModel_Factory implements Factory<LanguageViewModel> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public LanguageViewModel_Factory(Provider<SharedPreferences> sharedPreferencesProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public LanguageViewModel get() {
    return newInstance(sharedPreferencesProvider.get());
  }

  public static LanguageViewModel_Factory create(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new LanguageViewModel_Factory(sharedPreferencesProvider);
  }

  public static LanguageViewModel newInstance(SharedPreferences sharedPreferences) {
    return new LanguageViewModel(sharedPreferences);
  }
}
