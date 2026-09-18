package com.duomaker.couplelove.vatar.ui.main.success;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rJ*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/success/SuccessViewModel;", "Landroidx/lifecycle/ViewModel;", "appDataManager", "Lcom/duomaker/couplelove/vatar/data/datalocal/manager/AppDataManager;", "(Lcom/duomaker/couplelove/vatar/data/datalocal/manager/AppDataManager;)V", "deleteFile", "", "path", "", "isAvatar", "", "idEdit", "onDone", "Lkotlin/Function0;", "downloadFile", "context", "Landroid/content/Context;", "onResult", "Lkotlin/Function1;", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SuccessViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.duomaker.couplelove.vatar.data.datalocal.manager.AppDataManager appDataManager = null;
    
    @javax.inject.Inject()
    public SuccessViewModel(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.datalocal.manager.AppDataManager appDataManager) {
        super();
    }
    
    public final void downloadFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onResult) {
    }
    
    public final void deleteFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path, boolean isAvatar, @org.jetbrains.annotations.NotNull()
    java.lang.String idEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
}