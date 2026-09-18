package com.duomaker.couplelove.vatar.ui.main.success;

import com.duomaker.couplelove.vatar.data.datalocal.manager.AppDataManager;
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
public final class SuccessViewModel_Factory implements Factory<SuccessViewModel> {
  private final Provider<AppDataManager> appDataManagerProvider;

  public SuccessViewModel_Factory(Provider<AppDataManager> appDataManagerProvider) {
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public SuccessViewModel get() {
    return newInstance(appDataManagerProvider.get());
  }

  public static SuccessViewModel_Factory create(Provider<AppDataManager> appDataManagerProvider) {
    return new SuccessViewModel_Factory(appDataManagerProvider);
  }

  public static SuccessViewModel newInstance(AppDataManager appDataManager) {
    return new SuccessViewModel(appDataManager);
  }
}
