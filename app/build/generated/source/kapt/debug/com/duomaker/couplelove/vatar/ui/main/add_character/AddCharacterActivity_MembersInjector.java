package com.duomaker.couplelove.vatar.ui.main.add_character;

import com.duomaker.couplelove.vatar.AppSession;
import com.duomaker.couplelove.vatar.core.base.BaseActivity_MembersInjector;
import com.duomaker.couplelove.vatar.core.helper.SharedPreferencesManager;
import com.duomaker.couplelove.vatar.data.datalocal.manager.CharacterImageManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;

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
public final class AddCharacterActivity_MembersInjector implements MembersInjector<AddCharacterActivity> {
  private final Provider<AppSession> appSessionProvider;

  private final Provider<SharedPreferencesManager> sharedPreferencesProvider;

  private final Provider<CharacterImageManager> imageManagerProvider;

  public AddCharacterActivity_MembersInjector(Provider<AppSession> appSessionProvider,
      Provider<SharedPreferencesManager> sharedPreferencesProvider,
      Provider<CharacterImageManager> imageManagerProvider) {
    this.appSessionProvider = appSessionProvider;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    this.imageManagerProvider = imageManagerProvider;
  }

  public static MembersInjector<AddCharacterActivity> create(
      Provider<AppSession> appSessionProvider,
      Provider<SharedPreferencesManager> sharedPreferencesProvider,
      Provider<CharacterImageManager> imageManagerProvider) {
    return new AddCharacterActivity_MembersInjector(appSessionProvider, sharedPreferencesProvider, imageManagerProvider);
  }

  @Override
  public void injectMembers(AddCharacterActivity instance) {
    BaseActivity_MembersInjector.injectAppSession(instance, appSessionProvider.get());
    BaseActivity_MembersInjector.injectSharedPreferences(instance, sharedPreferencesProvider.get());
    injectImageManager(instance, imageManagerProvider.get());
  }

  @InjectedFieldSignature("com.duomaker.couplelove.vatar.ui.main.add_character.AddCharacterActivity.imageManager")
  public static void injectImageManager(AddCharacterActivity instance,
      CharacterImageManager imageManager) {
    instance.imageManager = imageManager;
  }
}
