package com.anime.oc.characters.avatar.ui.main.view;

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
public final class ViewViewModel_Factory implements Factory<ViewViewModel> {
  private final Provider<AppDataManager> appDataManagerProvider;

  public ViewViewModel_Factory(Provider<AppDataManager> appDataManagerProvider) {
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public ViewViewModel get() {
    return newInstance(appDataManagerProvider.get());
  }

  public static ViewViewModel_Factory create(Provider<AppDataManager> appDataManagerProvider) {
    return new ViewViewModel_Factory(appDataManagerProvider);
  }

  public static ViewViewModel newInstance(AppDataManager appDataManager) {
    return new ViewViewModel(appDataManager);
  }
}
