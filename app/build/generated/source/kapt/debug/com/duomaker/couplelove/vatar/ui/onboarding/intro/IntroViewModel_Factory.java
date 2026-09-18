package com.duomaker.couplelove.vatar.ui.onboarding.intro;

import com.duomaker.couplelove.vatar.core.helper.SharedPreferencesManager;
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
public final class IntroViewModel_Factory implements Factory<IntroViewModel> {
  private final Provider<SharedPreferencesManager> sharedPreferencesProvider;

  public IntroViewModel_Factory(Provider<SharedPreferencesManager> sharedPreferencesProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public IntroViewModel get() {
    return newInstance(sharedPreferencesProvider.get());
  }

  public static IntroViewModel_Factory create(
      Provider<SharedPreferencesManager> sharedPreferencesProvider) {
    return new IntroViewModel_Factory(sharedPreferencesProvider);
  }

  public static IntroViewModel newInstance(SharedPreferencesManager sharedPreferences) {
    return new IntroViewModel(sharedPreferences);
  }
}
