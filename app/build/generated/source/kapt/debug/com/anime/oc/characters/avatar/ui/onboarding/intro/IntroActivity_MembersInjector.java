package com.anime.oc.characters.avatar.ui.onboarding.intro;

import com.anime.oc.characters.avatar.AppSession;
import com.anime.oc.characters.avatar.core.base.BaseActivity_MembersInjector;
import com.anime.oc.characters.avatar.core.helper.SharedPreferencesManager;
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
public final class IntroActivity_MembersInjector implements MembersInjector<IntroActivity> {
  private final Provider<AppSession> appSessionProvider;

  private final Provider<SharedPreferencesManager> sharedPreferencesProvider;

  private final Provider<IntroAdapter> introAdapterProvider;

  public IntroActivity_MembersInjector(Provider<AppSession> appSessionProvider,
      Provider<SharedPreferencesManager> sharedPreferencesProvider,
      Provider<IntroAdapter> introAdapterProvider) {
    this.appSessionProvider = appSessionProvider;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    this.introAdapterProvider = introAdapterProvider;
  }

  public static MembersInjector<IntroActivity> create(Provider<AppSession> appSessionProvider,
      Provider<SharedPreferencesManager> sharedPreferencesProvider,
      Provider<IntroAdapter> introAdapterProvider) {
    return new IntroActivity_MembersInjector(appSessionProvider, sharedPreferencesProvider, introAdapterProvider);
  }

  @Override
  public void injectMembers(IntroActivity instance) {
    BaseActivity_MembersInjector.injectAppSession(instance, appSessionProvider.get());
    BaseActivity_MembersInjector.injectSharedPreferences(instance, sharedPreferencesProvider.get());
    injectIntroAdapter(instance, introAdapterProvider.get());
  }

  @InjectedFieldSignature("com.anime.oc.characters.avatar.ui.onboarding.intro.IntroActivity.introAdapter")
  public static void injectIntroAdapter(IntroActivity instance, IntroAdapter introAdapter) {
    instance.introAdapter = introAdapter;
  }
}
