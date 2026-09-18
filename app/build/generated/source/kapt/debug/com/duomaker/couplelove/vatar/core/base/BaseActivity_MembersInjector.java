package com.duomaker.couplelove.vatar.core.base;

import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBinding;
import com.duomaker.couplelove.vatar.AppSession;
import com.duomaker.couplelove.vatar.core.helper.SharedPreferencesManager;
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
public final class BaseActivity_MembersInjector<VB extends ViewBinding, VM extends ViewModel> implements MembersInjector<BaseActivity<VB, VM>> {
  private final Provider<AppSession> appSessionProvider;

  private final Provider<SharedPreferencesManager> sharedPreferencesProvider;

  public BaseActivity_MembersInjector(Provider<AppSession> appSessionProvider,
      Provider<SharedPreferencesManager> sharedPreferencesProvider) {
    this.appSessionProvider = appSessionProvider;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  public static <VB extends ViewBinding, VM extends ViewModel> MembersInjector<BaseActivity<VB, VM>> create(
      Provider<AppSession> appSessionProvider,
      Provider<SharedPreferencesManager> sharedPreferencesProvider) {
    return new BaseActivity_MembersInjector<VB, VM>(appSessionProvider, sharedPreferencesProvider);
  }

  @Override
  public void injectMembers(BaseActivity<VB, VM> instance) {
    injectAppSession(instance, appSessionProvider.get());
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
  }

  @InjectedFieldSignature("com.duomaker.couplelove.vatar.core.base.BaseActivity.appSession")
  public static <VB extends ViewBinding, VM extends ViewModel> void injectAppSession(
      BaseActivity<VB, VM> instance, AppSession appSession) {
    instance.appSession = appSession;
  }

  @InjectedFieldSignature("com.duomaker.couplelove.vatar.core.base.BaseActivity.sharedPreferences")
  public static <VB extends ViewBinding, VM extends ViewModel> void injectSharedPreferences(
      BaseActivity<VB, VM> instance, SharedPreferencesManager sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }
}
