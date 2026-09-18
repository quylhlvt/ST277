package com.duomaker.couplelove.vatar.ui.main.add_character;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class AddCharacterViewModel_Factory implements Factory<AddCharacterViewModel> {
  private final Provider<Context> contextProvider;

  public AddCharacterViewModel_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AddCharacterViewModel get() {
    return newInstance(contextProvider.get());
  }

  public static AddCharacterViewModel_Factory create(Provider<Context> contextProvider) {
    return new AddCharacterViewModel_Factory(contextProvider);
  }

  public static AddCharacterViewModel newInstance(Context context) {
    return new AddCharacterViewModel(context);
  }
}
