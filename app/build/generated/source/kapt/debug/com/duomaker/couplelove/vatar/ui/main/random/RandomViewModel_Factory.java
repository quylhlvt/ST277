package com.duomaker.couplelove.vatar.ui.main.random;

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
public final class RandomViewModel_Factory implements Factory<RandomViewModel> {
  private final Provider<AppDataManager> appDataManagerProvider;

  public RandomViewModel_Factory(Provider<AppDataManager> appDataManagerProvider) {
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public RandomViewModel get() {
    return newInstance(appDataManagerProvider.get());
  }

  public static RandomViewModel_Factory create(Provider<AppDataManager> appDataManagerProvider) {
    return new RandomViewModel_Factory(appDataManagerProvider);
  }

  public static RandomViewModel newInstance(AppDataManager appDataManager) {
    return new RandomViewModel(appDataManager);
  }
}
