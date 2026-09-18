package com.duomaker.couplelove.vatar.ui.main.myPony;

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
public final class MyPonyViewModel_Factory implements Factory<MyPonyViewModel> {
  private final Provider<AppDataManager> appDataManagerProvider;

  public MyPonyViewModel_Factory(Provider<AppDataManager> appDataManagerProvider) {
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public MyPonyViewModel get() {
    return newInstance(appDataManagerProvider.get());
  }

  public static MyPonyViewModel_Factory create(Provider<AppDataManager> appDataManagerProvider) {
    return new MyPonyViewModel_Factory(appDataManagerProvider);
  }

  public static MyPonyViewModel newInstance(AppDataManager appDataManager) {
    return new MyPonyViewModel(appDataManager);
  }
}
