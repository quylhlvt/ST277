package com.anime.oc.characters.avatar.data.usecase;

import android.content.Context;
import com.anime.oc.characters.avatar.data.datalocal.api.RemoteDataSource;
import com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager;
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
public final class GetCatalogueUseCase_Factory implements Factory<GetCatalogueUseCase> {
  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  private final Provider<AppDataManager> appDataManagerProvider;

  private final Provider<Context> contextProvider;

  public GetCatalogueUseCase_Factory(Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<AppDataManager> appDataManagerProvider, Provider<Context> contextProvider) {
    this.remoteDataSourceProvider = remoteDataSourceProvider;
    this.appDataManagerProvider = appDataManagerProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public GetCatalogueUseCase get() {
    return newInstance(remoteDataSourceProvider.get(), appDataManagerProvider.get(), contextProvider.get());
  }

  public static GetCatalogueUseCase_Factory create(
      Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<AppDataManager> appDataManagerProvider, Provider<Context> contextProvider) {
    return new GetCatalogueUseCase_Factory(remoteDataSourceProvider, appDataManagerProvider, contextProvider);
  }

  public static GetCatalogueUseCase newInstance(RemoteDataSource remoteDataSource,
      AppDataManager appDataManager, Context context) {
    return new GetCatalogueUseCase(remoteDataSource, appDataManager, context);
  }
}
