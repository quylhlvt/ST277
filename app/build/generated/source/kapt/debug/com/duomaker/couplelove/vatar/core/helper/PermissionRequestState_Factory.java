package com.duomaker.couplelove.vatar.core.helper;

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
public final class PermissionRequestState_Factory implements Factory<PermissionRequestState> {
  @Override
  public PermissionRequestState get() {
    return newInstance();
  }

  public static PermissionRequestState_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PermissionRequestState newInstance() {
    return new PermissionRequestState();
  }

  private static final class InstanceHolder {
    static final PermissionRequestState_Factory INSTANCE = new PermissionRequestState_Factory();
  }
}
