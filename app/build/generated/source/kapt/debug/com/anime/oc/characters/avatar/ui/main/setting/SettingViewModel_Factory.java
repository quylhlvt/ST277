package com.anime.oc.characters.avatar.ui.main.setting;

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
public final class SettingViewModel_Factory implements Factory<SettingViewModel> {
  @Override
  public SettingViewModel get() {
    return newInstance();
  }

  public static SettingViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SettingViewModel newInstance() {
    return new SettingViewModel();
  }

  private static final class InstanceHolder {
    static final SettingViewModel_Factory INSTANCE = new SettingViewModel_Factory();
  }
}
