package com.duomaker.couplelove.vatar.ui.main.customize;

import androidx.lifecycle.SavedStateHandle;
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
public final class CustomizeViewModel_Factory implements Factory<CustomizeViewModel> {
  private final Provider<AppDataManager> appDataManagerProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public CustomizeViewModel_Factory(Provider<AppDataManager> appDataManagerProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.appDataManagerProvider = appDataManagerProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public CustomizeViewModel get() {
    return newInstance(appDataManagerProvider.get(), savedStateHandleProvider.get());
  }

  public static CustomizeViewModel_Factory create(Provider<AppDataManager> appDataManagerProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new CustomizeViewModel_Factory(appDataManagerProvider, savedStateHandleProvider);
  }

  public static CustomizeViewModel newInstance(AppDataManager appDataManager,
      SavedStateHandle savedStateHandle) {
    return new CustomizeViewModel(appDataManager, savedStateHandle);
  }
}
