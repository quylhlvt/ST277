package com.duomaker.couplelove.vatar.ui.language;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/language/LanguageActivity;", "Lcom/duomaker/couplelove/vatar/core/base/BaseActivity;", "Lcom/duomaker/couplelove/vatar/databinding/ActivityLanguageBinding;", "Lcom/duomaker/couplelove/vatar/ui/language/LanguageViewModel;", "()V", "isFromSetting", "", "languageAdapter", "Lcom/duomaker/couplelove/vatar/ui/language/LanguageAdapter;", "getLanguageAdapter", "()Lcom/duomaker/couplelove/vatar/ui/language/LanguageAdapter;", "languageAdapter$delegate", "Lkotlin/Lazy;", "bindViewModel", "", "handleBackPressed", "handleDone", "handleRcv", "initRcv", "initView", "observeData", "setupPreViews", "updateActionBar", "isFirst", "updateDoneButtonVisibility", "viewListener", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class LanguageActivity extends com.duomaker.couplelove.vatar.core.base.BaseActivity<com.duomaker.couplelove.vatar.databinding.ActivityLanguageBinding, com.duomaker.couplelove.vatar.ui.language.LanguageViewModel> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy languageAdapter$delegate = null;
    private boolean isFromSetting = false;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_FROM_SETTING = "from_setting";
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.ui.language.LanguageActivity.Companion Companion = null;
    
    public LanguageActivity() {
        super(null, null);
    }
    
    private final com.duomaker.couplelove.vatar.ui.language.LanguageAdapter getLanguageAdapter() {
        return null;
    }
    
    @java.lang.Override()
    protected boolean handleBackPressed() {
        return false;
    }
    
    @java.lang.Override()
    public void setupPreViews() {
    }
    
    private final void updateActionBar(boolean isFirst) {
    }
    
    private final void updateDoneButtonVisibility() {
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
    
    private final void initRcv() {
    }
    
    private final void handleRcv() {
    }
    
    private final void handleDone() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/language/LanguageActivity$Companion;", "", "()V", "EXTRA_FROM_SETTING", "", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}