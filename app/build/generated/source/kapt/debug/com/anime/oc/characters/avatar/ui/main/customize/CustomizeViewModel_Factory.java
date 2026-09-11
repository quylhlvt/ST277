package com.anime.oc.characters.avatar.ui.main.customize;

import com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager;
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
public final class CustomizeViewModel_Factory implements Factory<CustomizeViewModel> {
  private final Provider<AppDataManager> appDataManagerProvider;

  public CustomizeViewModel_Factory(Provider<AppDataManager> appDataManagerProvider) {
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public CustomizeViewModel get() {
    return newInstance(appDataManagerProvider.get());
  }

  public static CustomizeViewModel_Factory create(Provider<AppDataManager> appDataManagerProvider) {
    return new CustomizeViewModel_Factory(appDataManagerProvider);
  }

  public static CustomizeViewModel newInstance(AppDataManager appDataManager) {
    return new CustomizeViewModel(appDataManager);
  }
}
