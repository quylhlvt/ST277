package com.anime.oc.characters.avatar.ui.main.createPony;

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
public final class ChoosePonyViewModel_Factory implements Factory<ChoosePonyViewModel> {
  private final Provider<AppDataManager> appDataManagerProvider;

  public ChoosePonyViewModel_Factory(Provider<AppDataManager> appDataManagerProvider) {
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public ChoosePonyViewModel get() {
    return newInstance(appDataManagerProvider.get());
  }

  public static ChoosePonyViewModel_Factory create(
      Provider<AppDataManager> appDataManagerProvider) {
    return new ChoosePonyViewModel_Factory(appDataManagerProvider);
  }

  public static ChoosePonyViewModel newInstance(AppDataManager appDataManager) {
    return new ChoosePonyViewModel(appDataManager);
  }
}
