package com.anime.oc.characters.avatar.data.datalocal.api;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class ApiHelper_Factory implements Factory<ApiHelper> {
  @Override
  public ApiHelper get() {
    return newInstance();
  }

  public static ApiHelper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ApiHelper newInstance() {
    return new ApiHelper();
  }

  private static final class InstanceHolder {
    static final ApiHelper_Factory INSTANCE = new ApiHelper_Factory();
  }
}
