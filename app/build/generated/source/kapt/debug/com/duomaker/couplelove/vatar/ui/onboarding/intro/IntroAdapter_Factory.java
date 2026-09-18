package com.duomaker.couplelove.vatar.ui.onboarding.intro;

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
public final class IntroAdapter_Factory implements Factory<IntroAdapter> {
  @Override
  public IntroAdapter get() {
    return newInstance();
  }

  public static IntroAdapter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static IntroAdapter newInstance() {
    return new IntroAdapter();
  }

  private static final class InstanceHolder {
    static final IntroAdapter_Factory INSTANCE = new IntroAdapter_Factory();
  }
}
