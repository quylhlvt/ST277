package com.duomaker.couplelove.vatar.ui.main.successcosplay;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class SuccessCosplayViewModel_Factory implements Factory<SuccessCosplayViewModel> {
  @Override
  public SuccessCosplayViewModel get() {
    return newInstance();
  }

  public static SuccessCosplayViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SuccessCosplayViewModel newInstance() {
    return new SuccessCosplayViewModel();
  }

  private static final class InstanceHolder {
    static final SuccessCosplayViewModel_Factory INSTANCE = new SuccessCosplayViewModel_Factory();
  }
}
