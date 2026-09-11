package com.anime.oc.characters.avatar.ui.main.show;

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
public final class ShowViewModel_Factory implements Factory<ShowViewModel> {
  private final Provider<AppDataManager> appDataManagerProvider;

  public ShowViewModel_Factory(Provider<AppDataManager> appDataManagerProvider) {
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public ShowViewModel get() {
    return newInstance(appDataManagerProvider.get());
  }

  public static ShowViewModel_Factory create(Provider<AppDataManager> appDataManagerProvider) {
    return new ShowViewModel_Factory(appDataManagerProvider);
  }

  public static ShowViewModel newInstance(AppDataManager appDataManager) {
    return new ShowViewModel(appDataManager);
  }
}
