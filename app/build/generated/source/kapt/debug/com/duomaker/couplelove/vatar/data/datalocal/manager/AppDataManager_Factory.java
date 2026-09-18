package com.duomaker.couplelove.vatar.data.datalocal.manager;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppDataManager_Factory implements Factory<AppDataManager> {
  private final Provider<Context> contextProvider;

  public AppDataManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AppDataManager get() {
    return newInstance(contextProvider.get());
  }

  public static AppDataManager_Factory create(Provider<Context> contextProvider) {
    return new AppDataManager_Factory(contextProvider);
  }

  public static AppDataManager newInstance(Context context) {
    return new AppDataManager(context);
  }
}
