package com.anime.oc.characters.avatar;

import android.app.Activity;
import android.app.Service;
import android.content.SharedPreferences;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.anime.oc.characters.avatar.core.base.BaseActivity_MembersInjector;
import com.anime.oc.characters.avatar.core.helper.NetworkMonitor;
import com.anime.oc.characters.avatar.core.helper.PermissionRequestState;
import com.anime.oc.characters.avatar.core.helper.SharedPreferencesManager;
import com.anime.oc.characters.avatar.data.datalocal.api.ApiHelper;
import com.anime.oc.characters.avatar.data.datalocal.api.RemoteDataSource;
import com.anime.oc.characters.avatar.data.datalocal.di.DataLocalModule_ProvideNetworkFlowFactory;
import com.anime.oc.characters.avatar.data.datalocal.di.DataLocalModule_ProvideNetworkMonitorFactory;
import com.anime.oc.characters.avatar.data.datalocal.di.DataLocalModule_ProvideSharedPreferencesEditorFactory;
import com.anime.oc.characters.avatar.data.datalocal.di.DataLocalModule_ProvideSharedPreferencesFactory;
import com.anime.oc.characters.avatar.data.datalocal.di.DataLocalModule_ProvideSharedPreferencesManagerFactory;
import com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager;
import com.anime.oc.characters.avatar.data.datalocal.manager.CharacterImageManager;
import com.anime.oc.characters.avatar.data.usecase.GetCatalogueUseCase;
import com.anime.oc.characters.avatar.ui.language.LanguageActivity;
import com.anime.oc.characters.avatar.ui.language.LanguageViewModel;
import com.anime.oc.characters.avatar.ui.language.LanguageViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.language.LanguageViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.language.LanguageViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.add_character.AddCharacterActivity;
import com.anime.oc.characters.avatar.ui.main.add_character.AddCharacterActivity_MembersInjector;
import com.anime.oc.characters.avatar.ui.main.add_character.AddCharacterViewModel;
import com.anime.oc.characters.avatar.ui.main.add_character.AddCharacterViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.add_character.AddCharacterViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.add_character.AddCharacterViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.cosplay.CosplayActivity;
import com.anime.oc.characters.avatar.ui.main.cosplay.CosplayViewModel;
import com.anime.oc.characters.avatar.ui.main.cosplay.CosplayViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.cosplay.CosplayViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.cosplay.CosplayViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.createPony.ChoosePonyActivity;
import com.anime.oc.characters.avatar.ui.main.createPony.ChoosePonyViewModel;
import com.anime.oc.characters.avatar.ui.main.createPony.ChoosePonyViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.createPony.ChoosePonyViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.createPony.ChoosePonyViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.customize.CustomizeActivity;
import com.anime.oc.characters.avatar.ui.main.customize.CustomizeViewModel;
import com.anime.oc.characters.avatar.ui.main.customize.CustomizeViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.customize.CustomizeViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.customize.CustomizeViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.home.HomeActivity;
import com.anime.oc.characters.avatar.ui.main.home.HomeViewModel;
import com.anime.oc.characters.avatar.ui.main.home.HomeViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.home.HomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.home.HomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.myPony.MyPonyActivity;
import com.anime.oc.characters.avatar.ui.main.myPony.MyPonyViewModel;
import com.anime.oc.characters.avatar.ui.main.myPony.MyPonyViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.myPony.MyPonyViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.myPony.MyPonyViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.random.RandomActivity;
import com.anime.oc.characters.avatar.ui.main.random.RandomViewModel;
import com.anime.oc.characters.avatar.ui.main.random.RandomViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.random.RandomViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.random.RandomViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.setting.SettingActivity;
import com.anime.oc.characters.avatar.ui.main.setting.SettingViewModel;
import com.anime.oc.characters.avatar.ui.main.setting.SettingViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.setting.SettingViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.setting.SettingViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.show.ShowActivity;
import com.anime.oc.characters.avatar.ui.main.show.ShowViewModel;
import com.anime.oc.characters.avatar.ui.main.show.ShowViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.show.ShowViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.show.ShowViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.success.SuccessActivity;
import com.anime.oc.characters.avatar.ui.main.success.SuccessViewModel;
import com.anime.oc.characters.avatar.ui.main.success.SuccessViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.success.SuccessViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.success.SuccessViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.successcosplay.SuccessCosplayActivity;
import com.anime.oc.characters.avatar.ui.main.successcosplay.SuccessCosplayViewModel;
import com.anime.oc.characters.avatar.ui.main.successcosplay.SuccessCosplayViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.successcosplay.SuccessCosplayViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.successcosplay.SuccessCosplayViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.view.ViewActivity;
import com.anime.oc.characters.avatar.ui.main.view.ViewViewModel;
import com.anime.oc.characters.avatar.ui.main.view.ViewViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.main.view.ViewViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.main.view.ViewViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.onboarding.intro.IntroActivity;
import com.anime.oc.characters.avatar.ui.onboarding.intro.IntroActivity_MembersInjector;
import com.anime.oc.characters.avatar.ui.onboarding.intro.IntroAdapter;
import com.anime.oc.characters.avatar.ui.onboarding.intro.IntroViewModel;
import com.anime.oc.characters.avatar.ui.onboarding.intro.IntroViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.onboarding.intro.IntroViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.onboarding.intro.IntroViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionActivity;
import com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionViewModel;
import com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.anime.oc.characters.avatar.ui.onboarding.splash.SplashActivity;
import com.anime.oc.characters.avatar.ui.onboarding.splash.SplashViewModel;
import com.anime.oc.characters.avatar.ui.onboarding.splash.SplashViewModel_HiltModules;
import com.anime.oc.characters.avatar.ui.onboarding.splash.SplashViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.anime.oc.characters.avatar.ui.onboarding.splash.SplashViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

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
public final class DaggerMyApplication_HiltComponents_SingletonC {
  private DaggerMyApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public MyApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements MyApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements MyApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements MyApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements MyApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements MyApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements MyApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements MyApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends MyApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends MyApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    FragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends MyApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends MyApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectLanguageActivity(LanguageActivity arg0) {
      injectLanguageActivity2(arg0);
    }

    @Override
    public void injectAddCharacterActivity(AddCharacterActivity arg0) {
      injectAddCharacterActivity2(arg0);
    }

    @Override
    public void injectCosplayActivity(CosplayActivity arg0) {
      injectCosplayActivity2(arg0);
    }

    @Override
    public void injectChoosePonyActivity(ChoosePonyActivity arg0) {
      injectChoosePonyActivity2(arg0);
    }

    @Override
    public void injectCustomizeActivity(CustomizeActivity arg0) {
      injectCustomizeActivity2(arg0);
    }

    @Override
    public void injectHomeActivity(HomeActivity arg0) {
      injectHomeActivity2(arg0);
    }

    @Override
    public void injectMyPonyActivity(MyPonyActivity arg0) {
      injectMyPonyActivity2(arg0);
    }

    @Override
    public void injectRandomActivity(RandomActivity arg0) {
      injectRandomActivity2(arg0);
    }

    @Override
    public void injectSettingActivity(SettingActivity arg0) {
      injectSettingActivity2(arg0);
    }

    @Override
    public void injectShowActivity(ShowActivity arg0) {
      injectShowActivity2(arg0);
    }

    @Override
    public void injectSuccessActivity(SuccessActivity arg0) {
      injectSuccessActivity2(arg0);
    }

    @Override
    public void injectSuccessCosplayActivity(SuccessCosplayActivity arg0) {
      injectSuccessCosplayActivity2(arg0);
    }

    @Override
    public void injectViewActivity(ViewActivity arg0) {
      injectViewActivity2(arg0);
    }

    @Override
    public void injectIntroActivity(IntroActivity arg0) {
      injectIntroActivity2(arg0);
    }

    @Override
    public void injectPermissionActivity(PermissionActivity arg0) {
      injectPermissionActivity2(arg0);
    }

    @Override
    public void injectSplashActivity(SplashActivity arg0) {
      injectSplashActivity2(arg0);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>builderWithExpectedSize(16).put(AddCharacterViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, AddCharacterViewModel_HiltModules.KeyModule.provide()).put(ChoosePonyViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ChoosePonyViewModel_HiltModules.KeyModule.provide()).put(CosplayViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, CosplayViewModel_HiltModules.KeyModule.provide()).put(CustomizeViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, CustomizeViewModel_HiltModules.KeyModule.provide()).put(HomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, HomeViewModel_HiltModules.KeyModule.provide()).put(IntroViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, IntroViewModel_HiltModules.KeyModule.provide()).put(LanguageViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, LanguageViewModel_HiltModules.KeyModule.provide()).put(MyPonyViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, MyPonyViewModel_HiltModules.KeyModule.provide()).put(PermissionViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, PermissionViewModel_HiltModules.KeyModule.provide()).put(RandomViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, RandomViewModel_HiltModules.KeyModule.provide()).put(SettingViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SettingViewModel_HiltModules.KeyModule.provide()).put(ShowViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ShowViewModel_HiltModules.KeyModule.provide()).put(SplashViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SplashViewModel_HiltModules.KeyModule.provide()).put(SuccessCosplayViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SuccessCosplayViewModel_HiltModules.KeyModule.provide()).put(SuccessViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SuccessViewModel_HiltModules.KeyModule.provide()).put(ViewViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ViewViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @CanIgnoreReturnValue
    private LanguageActivity injectLanguageActivity2(LanguageActivity instance) {
      BaseActivity_MembersInjector.injectAppSession(instance, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private AddCharacterActivity injectAddCharacterActivity2(AddCharacterActivity instance2) {
      BaseActivity_MembersInjector.injectAppSession(instance2, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance2, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      AddCharacterActivity_MembersInjector.injectImageManager(instance2, singletonCImpl.characterImageManagerProvider.get());
      return instance2;
    }

    @CanIgnoreReturnValue
    private CosplayActivity injectCosplayActivity2(CosplayActivity instance3) {
      BaseActivity_MembersInjector.injectAppSession(instance3, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance3, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance3;
    }

    @CanIgnoreReturnValue
    private ChoosePonyActivity injectChoosePonyActivity2(ChoosePonyActivity instance4) {
      BaseActivity_MembersInjector.injectAppSession(instance4, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance4, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance4;
    }

    @CanIgnoreReturnValue
    private CustomizeActivity injectCustomizeActivity2(CustomizeActivity instance5) {
      BaseActivity_MembersInjector.injectAppSession(instance5, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance5, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance5;
    }

    @CanIgnoreReturnValue
    private HomeActivity injectHomeActivity2(HomeActivity instance6) {
      BaseActivity_MembersInjector.injectAppSession(instance6, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance6, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance6;
    }

    @CanIgnoreReturnValue
    private MyPonyActivity injectMyPonyActivity2(MyPonyActivity instance7) {
      BaseActivity_MembersInjector.injectAppSession(instance7, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance7, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance7;
    }

    @CanIgnoreReturnValue
    private RandomActivity injectRandomActivity2(RandomActivity instance8) {
      BaseActivity_MembersInjector.injectAppSession(instance8, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance8, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance8;
    }

    @CanIgnoreReturnValue
    private SettingActivity injectSettingActivity2(SettingActivity instance9) {
      BaseActivity_MembersInjector.injectAppSession(instance9, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance9, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance9;
    }

    @CanIgnoreReturnValue
    private ShowActivity injectShowActivity2(ShowActivity instance10) {
      BaseActivity_MembersInjector.injectAppSession(instance10, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance10, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance10;
    }

    @CanIgnoreReturnValue
    private SuccessActivity injectSuccessActivity2(SuccessActivity instance11) {
      BaseActivity_MembersInjector.injectAppSession(instance11, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance11, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance11;
    }

    @CanIgnoreReturnValue
    private SuccessCosplayActivity injectSuccessCosplayActivity2(
        SuccessCosplayActivity instance12) {
      BaseActivity_MembersInjector.injectAppSession(instance12, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance12, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance12;
    }

    @CanIgnoreReturnValue
    private ViewActivity injectViewActivity2(ViewActivity instance13) {
      BaseActivity_MembersInjector.injectAppSession(instance13, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance13, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance13;
    }

    @CanIgnoreReturnValue
    private IntroActivity injectIntroActivity2(IntroActivity instance14) {
      BaseActivity_MembersInjector.injectAppSession(instance14, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance14, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      IntroActivity_MembersInjector.injectIntroAdapter(instance14, new IntroAdapter());
      return instance14;
    }

    @CanIgnoreReturnValue
    private PermissionActivity injectPermissionActivity2(PermissionActivity instance15) {
      BaseActivity_MembersInjector.injectAppSession(instance15, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance15, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance15;
    }

    @CanIgnoreReturnValue
    private SplashActivity injectSplashActivity2(SplashActivity instance16) {
      BaseActivity_MembersInjector.injectAppSession(instance16, singletonCImpl.appSessionProvider.get());
      BaseActivity_MembersInjector.injectSharedPreferences(instance16, singletonCImpl.provideSharedPreferencesManagerProvider.get());
      return instance16;
    }
  }

  private static final class ViewModelCImpl extends MyApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    Provider<AddCharacterViewModel> addCharacterViewModelProvider;

    Provider<ChoosePonyViewModel> choosePonyViewModelProvider;

    Provider<CosplayViewModel> cosplayViewModelProvider;

    Provider<CustomizeViewModel> customizeViewModelProvider;

    Provider<HomeViewModel> homeViewModelProvider;

    Provider<IntroViewModel> introViewModelProvider;

    Provider<LanguageViewModel> languageViewModelProvider;

    Provider<MyPonyViewModel> myPonyViewModelProvider;

    Provider<PermissionViewModel> permissionViewModelProvider;

    Provider<RandomViewModel> randomViewModelProvider;

    Provider<SettingViewModel> settingViewModelProvider;

    Provider<ShowViewModel> showViewModelProvider;

    Provider<SplashViewModel> splashViewModelProvider;

    Provider<SuccessCosplayViewModel> successCosplayViewModelProvider;

    Provider<SuccessViewModel> successViewModelProvider;

    Provider<ViewViewModel> viewViewModelProvider;

    ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.addCharacterViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.choosePonyViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.cosplayViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.customizeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.introViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.languageViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.myPonyViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.permissionViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.randomViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
      this.settingViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 10);
      this.showViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 11);
      this.splashViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 12);
      this.successCosplayViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 13);
      this.successViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 14);
      this.viewViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 15);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>builderWithExpectedSize(16).put(AddCharacterViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) addCharacterViewModelProvider)).put(ChoosePonyViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) choosePonyViewModelProvider)).put(CosplayViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) cosplayViewModelProvider)).put(CustomizeViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) customizeViewModelProvider)).put(HomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) homeViewModelProvider)).put(IntroViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) introViewModelProvider)).put(LanguageViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) languageViewModelProvider)).put(MyPonyViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) myPonyViewModelProvider)).put(PermissionViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) permissionViewModelProvider)).put(RandomViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) randomViewModelProvider)).put(SettingViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) settingViewModelProvider)).put(ShowViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) showViewModelProvider)).put(SplashViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) splashViewModelProvider)).put(SuccessCosplayViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) successCosplayViewModelProvider)).put(SuccessViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) successViewModelProvider)).put(ViewViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) viewViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.anime.oc.characters.avatar.ui.main.add_character.AddCharacterViewModel
          return (T) new AddCharacterViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.anime.oc.characters.avatar.ui.main.createPony.ChoosePonyViewModel
          return (T) new ChoosePonyViewModel(singletonCImpl.appDataManagerProvider.get());

          case 2: // com.anime.oc.characters.avatar.ui.main.cosplay.CosplayViewModel
          return (T) new CosplayViewModel(singletonCImpl.appDataManagerProvider.get());

          case 3: // com.anime.oc.characters.avatar.ui.main.customize.CustomizeViewModel
          return (T) new CustomizeViewModel(singletonCImpl.appDataManagerProvider.get());

          case 4: // com.anime.oc.characters.avatar.ui.main.home.HomeViewModel
          return (T) new HomeViewModel();

          case 5: // com.anime.oc.characters.avatar.ui.onboarding.intro.IntroViewModel
          return (T) new IntroViewModel(singletonCImpl.provideSharedPreferencesManagerProvider.get());

          case 6: // com.anime.oc.characters.avatar.ui.language.LanguageViewModel
          return (T) new LanguageViewModel(singletonCImpl.provideSharedPreferencesProvider.get());

          case 7: // com.anime.oc.characters.avatar.ui.main.myPony.MyPonyViewModel
          return (T) new MyPonyViewModel(singletonCImpl.appDataManagerProvider.get());

          case 8: // com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionViewModel
          return (T) new PermissionViewModel(singletonCImpl.permissionRequestStateProvider.get());

          case 9: // com.anime.oc.characters.avatar.ui.main.random.RandomViewModel
          return (T) new RandomViewModel(singletonCImpl.appDataManagerProvider.get());

          case 10: // com.anime.oc.characters.avatar.ui.main.setting.SettingViewModel
          return (T) new SettingViewModel();

          case 11: // com.anime.oc.characters.avatar.ui.main.show.ShowViewModel
          return (T) new ShowViewModel(singletonCImpl.appDataManagerProvider.get());

          case 12: // com.anime.oc.characters.avatar.ui.onboarding.splash.SplashViewModel
          return (T) new SplashViewModel();

          case 13: // com.anime.oc.characters.avatar.ui.main.successcosplay.SuccessCosplayViewModel
          return (T) new SuccessCosplayViewModel();

          case 14: // com.anime.oc.characters.avatar.ui.main.success.SuccessViewModel
          return (T) new SuccessViewModel(singletonCImpl.appDataManagerProvider.get());

          case 15: // com.anime.oc.characters.avatar.ui.main.view.ViewViewModel
          return (T) new ViewViewModel(singletonCImpl.appDataManagerProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends MyApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends MyApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends MyApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    Provider<ApiHelper> apiHelperProvider;

    Provider<RemoteDataSource> remoteDataSourceProvider;

    Provider<AppDataManager> appDataManagerProvider;

    Provider<GetCatalogueUseCase> getCatalogueUseCaseProvider;

    Provider<NetworkMonitor> provideNetworkMonitorProvider;

    Provider<AppSession> appSessionProvider;

    Provider<SharedPreferences> provideSharedPreferencesProvider;

    Provider<SharedPreferences.Editor> provideSharedPreferencesEditorProvider;

    Provider<SharedPreferencesManager> provideSharedPreferencesManagerProvider;

    Provider<CharacterImageManager> characterImageManagerProvider;

    Provider<PermissionRequestState> permissionRequestStateProvider;

    SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    Flow<Boolean> flowOfBoolean() {
      return DataLocalModule_ProvideNetworkFlowFactory.provideNetworkFlow(provideNetworkMonitorProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.apiHelperProvider = DoubleCheck.provider(new SwitchingProvider<ApiHelper>(singletonCImpl, 3));
      this.remoteDataSourceProvider = DoubleCheck.provider(new SwitchingProvider<RemoteDataSource>(singletonCImpl, 2));
      this.appDataManagerProvider = DoubleCheck.provider(new SwitchingProvider<AppDataManager>(singletonCImpl, 4));
      this.getCatalogueUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<GetCatalogueUseCase>(singletonCImpl, 1));
      this.provideNetworkMonitorProvider = DoubleCheck.provider(new SwitchingProvider<NetworkMonitor>(singletonCImpl, 5));
      this.appSessionProvider = DoubleCheck.provider(new SwitchingProvider<AppSession>(singletonCImpl, 0));
      this.provideSharedPreferencesProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferences>(singletonCImpl, 7));
      this.provideSharedPreferencesEditorProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferences.Editor>(singletonCImpl, 8));
      this.provideSharedPreferencesManagerProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferencesManager>(singletonCImpl, 6));
      this.characterImageManagerProvider = DoubleCheck.provider(new SwitchingProvider<CharacterImageManager>(singletonCImpl, 9));
      this.permissionRequestStateProvider = DoubleCheck.provider(new SwitchingProvider<PermissionRequestState>(singletonCImpl, 10));
    }

    @Override
    public void injectMyApplication(MyApplication myApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.anime.oc.characters.avatar.AppSession
          return (T) new AppSession(singletonCImpl.getCatalogueUseCaseProvider.get(), singletonCImpl.appDataManagerProvider.get(), singletonCImpl.flowOfBoolean(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.anime.oc.characters.avatar.data.usecase.GetCatalogueUseCase
          return (T) new GetCatalogueUseCase(singletonCImpl.remoteDataSourceProvider.get(), singletonCImpl.appDataManagerProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 2: // com.anime.oc.characters.avatar.data.datalocal.api.RemoteDataSource
          return (T) new RemoteDataSource(singletonCImpl.apiHelperProvider.get());

          case 3: // com.anime.oc.characters.avatar.data.datalocal.api.ApiHelper
          return (T) new ApiHelper();

          case 4: // com.anime.oc.characters.avatar.data.datalocal.manager.AppDataManager
          return (T) new AppDataManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 5: // com.anime.oc.characters.avatar.core.helper.NetworkMonitor
          return (T) DataLocalModule_ProvideNetworkMonitorFactory.provideNetworkMonitor(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 6: // com.anime.oc.characters.avatar.core.helper.SharedPreferencesManager
          return (T) DataLocalModule_ProvideSharedPreferencesManagerFactory.provideSharedPreferencesManager(singletonCImpl.provideSharedPreferencesProvider.get(), singletonCImpl.provideSharedPreferencesEditorProvider.get());

          case 7: // android.content.SharedPreferences
          return (T) DataLocalModule_ProvideSharedPreferencesFactory.provideSharedPreferences(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 8: // android.content.SharedPreferences.Editor
          return (T) DataLocalModule_ProvideSharedPreferencesEditorFactory.provideSharedPreferencesEditor(singletonCImpl.provideSharedPreferencesProvider.get());

          case 9: // com.anime.oc.characters.avatar.data.datalocal.manager.CharacterImageManager
          return (T) new CharacterImageManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 10: // com.anime.oc.characters.avatar.core.helper.PermissionRequestState
          return (T) new PermissionRequestState();

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
