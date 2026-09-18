package com.duomaker.couplelove.vatar.data.repository;

import com.duomaker.couplelove.vatar.data.datalocal.api.CatalogueApi;
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
public final class ApiRepository_Factory implements Factory<ApiRepository> {
  private final Provider<CatalogueApi> catalogueApiProvider;

  public ApiRepository_Factory(Provider<CatalogueApi> catalogueApiProvider) {
    this.catalogueApiProvider = catalogueApiProvider;
  }

  @Override
  public ApiRepository get() {
    return newInstance(catalogueApiProvider.get());
  }

  public static ApiRepository_Factory create(Provider<CatalogueApi> catalogueApiProvider) {
    return new ApiRepository_Factory(catalogueApiProvider);
  }

  public static ApiRepository newInstance(CatalogueApi catalogueApi) {
    return new ApiRepository(catalogueApi);
  }
}
