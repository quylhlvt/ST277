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
public final class CharacterImageManager_Factory implements Factory<CharacterImageManager> {
  private final Provider<Context> contextProvider;

  public CharacterImageManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public CharacterImageManager get() {
    return newInstance(contextProvider.get());
  }

  public static CharacterImageManager_Factory create(Provider<Context> contextProvider) {
    return new CharacterImageManager_Factory(contextProvider);
  }

  public static CharacterImageManager newInstance(Context context) {
    return new CharacterImageManager(context);
  }
}
