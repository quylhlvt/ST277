package com.duomaker.couplelove.vatar.data.datalocal.api;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class RemoteDataSource_Factory implements Factory<RemoteDataSource> {
  private final Provider<ApiHelper> apiHelperProvider;

  public RemoteDataSource_Factory(Provider<ApiHelper> apiHelperProvider) {
    this.apiHelperProvider = apiHelperProvider;
  }

  @Override
  public RemoteDataSource get() {
    return newInstance(apiHelperProvider.get());
  }

  public static RemoteDataSource_Factory create(Provider<ApiHelper> apiHelperProvider) {
    return new RemoteDataSource_Factory(apiHelperProvider);
  }

  public static RemoteDataSource newInstance(ApiHelper apiHelper) {
    return new RemoteDataSource(apiHelper);
  }
}
