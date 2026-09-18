package com.duomaker.couplelove.vatar.ui.main.cosplay;

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
public final class CosplayViewModel_Factory implements Factory<CosplayViewModel> {
  private final Provider<AppDataManager> appDataManagerProvider;

  public CosplayViewModel_Factory(Provider<AppDataManager> appDataManagerProvider) {
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public CosplayViewModel get() {
    return newInstance(appDataManagerProvider.get());
  }

  public static CosplayViewModel_Factory create(Provider<AppDataManager> appDataManagerProvider) {
    return new CosplayViewModel_Factory(appDataManagerProvider);
  }

  public static CosplayViewModel newInstance(AppDataManager appDataManager) {
    return new CosplayViewModel(appDataManager);
  }
}
