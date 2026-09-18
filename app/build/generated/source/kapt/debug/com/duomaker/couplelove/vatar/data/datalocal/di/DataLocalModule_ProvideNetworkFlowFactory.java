package com.duomaker.couplelove.vatar.data.datalocal.di;

import com.duomaker.couplelove.vatar.core.helper.NetworkMonitor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

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
public final class DataLocalModule_ProvideNetworkFlowFactory implements Factory<Flow<Boolean>> {
  private final Provider<NetworkMonitor> networkMonitorProvider;

  public DataLocalModule_ProvideNetworkFlowFactory(
      Provider<NetworkMonitor> networkMonitorProvider) {
    this.networkMonitorProvider = networkMonitorProvider;
  }

  @Override
  public Flow<Boolean> get() {
    return provideNetworkFlow(networkMonitorProvider.get());
  }

  public static DataLocalModule_ProvideNetworkFlowFactory create(
      Provider<NetworkMonitor> networkMonitorProvider) {
    return new DataLocalModule_ProvideNetworkFlowFactory(networkMonitorProvider);
  }

  public static Flow<Boolean> provideNetworkFlow(NetworkMonitor networkMonitor) {
    return Preconditions.checkNotNullFromProvides(DataLocalModule.INSTANCE.provideNetworkFlow(networkMonitor));
  }
}
