package com.anime.oc.characters.avatar.ui.main.createPony;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/createPony/ChoosePonyActivity;", "Lcom/anime/oc/characters/avatar/core/base/BaseActivity;", "Lcom/anime/oc/characters/avatar/databinding/ActivityChoosePonyBinding;", "Lcom/anime/oc/characters/avatar/ui/main/createPony/ChoosePonyViewModel;", "()V", "adapter", "Lcom/anime/oc/characters/avatar/ui/main/createPony/ChoosePonyAdapter;", "isFirstLoad", "", "bindViewModel", "", "handleBackPressed", "initView", "navigateBack", "navigateToCustomize", "character", "Lcom/anime/oc/characters/avatar/data/model/custom/CustomModel;", "index", "", "observeData", "onResume", "viewListener", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class ChoosePonyActivity extends com.anime.oc.characters.avatar.core.base.BaseActivity<com.anime.oc.characters.avatar.databinding.ActivityChoosePonyBinding, com.anime.oc.characters.avatar.ui.main.createPony.ChoosePonyViewModel> {
    private com.anime.oc.characters.avatar.ui.main.createPony.ChoosePonyAdapter adapter;
    private boolean isFirstLoad = true;
    
    public ChoosePonyActivity() {
        super(null, null);
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    private final void navigateToCustomize(com.anime.oc.characters.avatar.data.model.custom.CustomModel character, int index) {
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    private final void navigateBack() {
    }
    
    @java.lang.Override()
    protected boolean handleBackPressed() {
        return false;
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
}