package com.anime.oc.characters.avatar.ui.onboarding.permission;

import com.anime.oc.characters.avatar.core.helper.PermissionRequestState;
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
public final class PermissionViewModel_Factory implements Factory<PermissionViewModel> {
  private final Provider<PermissionRequestState> permissionStateProvider;

  public PermissionViewModel_Factory(Provider<PermissionRequestState> permissionStateProvider) {
    this.permissionStateProvider = permissionStateProvider;
  }

  @Override
  public PermissionViewModel get() {
    return newInstance(permissionStateProvider.get());
  }

  public static PermissionViewModel_Factory create(
      Provider<PermissionRequestState> permissionStateProvider) {
    return new PermissionViewModel_Factory(permissionStateProvider);
  }

  public static PermissionViewModel newInstance(PermissionRequestState permissionState) {
    return new PermissionViewModel(permissionState);
  }
}
