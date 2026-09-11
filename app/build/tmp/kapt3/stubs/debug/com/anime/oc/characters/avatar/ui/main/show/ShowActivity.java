package com.anime.oc.characters.avatar.ui.main.show;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 X2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001XB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010+\u001a\u00020,H\u0016J\u0016\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J&\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f0/2\b\u00102\u001a\u0004\u0018\u0001002\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001f0/H\u0002J\b\u00104\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020,H\u0002J\b\u00106\u001a\u00020,H\u0016J\b\u00107\u001a\u00020\u0017H\u0002J\u0018\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001fH\u0002J\b\u0010<\u001a\u00020,H\u0002J\b\u0010=\u001a\u00020,H\u0016J\b\u0010>\u001a\u00020,H\u0014J\b\u0010?\u001a\u00020,H\u0002J\b\u0010@\u001a\u00020,H\u0014J\b\u0010A\u001a\u00020,H\u0014J\b\u0010B\u001a\u00020,H\u0002J\u0010\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020EH\u0002J\n\u0010F\u001a\u0004\u0018\u00010GH\u0002J\b\u0010H\u001a\u00020,H\u0002J\b\u0010I\u001a\u00020,H\u0002J\u0010\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020\u0017H\u0002J\b\u0010L\u001a\u00020,H\u0002J\b\u0010M\u001a\u00020,H\u0002J\u0012\u0010N\u001a\u00020,2\b\b\u0002\u0010O\u001a\u00020 H\u0002J\u0010\u0010P\u001a\u00020,2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010Q\u001a\u00020,2\u0006\u0010K\u001a\u00020\u0017H\u0002J\u0010\u0010R\u001a\u00020,2\u0006\u0010S\u001a\u00020 H\u0002J\u0018\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020 H\u0002J\b\u0010W\u001a\u00020,H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020 X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006Y"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/show/ShowActivity;", "Lcom/anime/oc/characters/avatar/core/base/BaseActivity;", "Lcom/anime/oc/characters/avatar/databinding/ActivityShowBinding;", "Lcom/anime/oc/characters/avatar/ui/main/show/ShowViewModel;", "()V", "adapterColor", "Lcom/anime/oc/characters/avatar/ui/main/customize/ColorAdapter;", "getAdapterColor", "()Lcom/anime/oc/characters/avatar/ui/main/customize/ColorAdapter;", "adapterColor$delegate", "Lkotlin/Lazy;", "adapterNav", "Lcom/anime/oc/characters/avatar/ui/main/customize/NavAdapter;", "getAdapterNav", "()Lcom/anime/oc/characters/avatar/ui/main/customize/NavAdapter;", "adapterNav$delegate", "adapterPart", "Lcom/anime/oc/characters/avatar/ui/main/customize/PartAdapter;", "getAdapterPart", "()Lcom/anime/oc/characters/avatar/ui/main/customize/PartAdapter;", "adapterPart$delegate", "arrShowColor", "", "", "hasNavigatedToSuccess", "hasTriggeredReInit", "layerViews", "Ljava/util/ArrayList;", "Landroidx/appcompat/widget/AppCompatImageView;", "navToLayerIndex", "", "", "", "pendingLoads", "Ljava/util/concurrent/atomic/AtomicInteger;", "remainingSeconds", "remainingSecondsOnPause", "scrollPartAfterRandom", "starAnimator", "Landroid/animation/ValueAnimator;", "timerJob", "Lkotlinx/coroutines/Job;", "totalSeconds", "bindViewModel", "", "buildLayerViews", "parts", "", "Lcom/anime/oc/characters/avatar/data/model/custom/BodyPartModel;", "buildThumbList", "bp", "paths", "checkOnlineNetworkOrShowDialog", "doNavigateToSuccess", "initView", "isOnlineTemplate", "loadImageIntoView", "view", "Landroid/widget/ImageView;", "path", "navigateToSuccess", "observeData", "onDestroy", "onLoadFinished", "onPause", "onResume", "readArgsAndInit", "renderLayers", "state", "Lcom/anime/oc/characters/avatar/ui/main/show/ShowState;", "renderLayersToBitmap", "Landroid/graphics/Bitmap;", "setupAdapters", "showFailLayout", "showResultDialog", "isComplete", "showWinLayout", "startCountDown", "startTimer", "fromSeconds", "updateAdapters", "updateCompletionDialog", "updateMatchUI", "percent", "updateTimerUI", "minutes", "seconds", "viewListener", "Companion", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class ShowActivity extends com.anime.oc.characters.avatar.core.base.BaseActivity<com.anime.oc.characters.avatar.databinding.ActivityShowBinding, com.anime.oc.characters.avatar.ui.main.show.ShowViewModel> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<androidx.appcompat.widget.AppCompatImageView> layerViews = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Integer> navToLayerIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Boolean> arrShowColor = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapterNav$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapterColor$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapterPart$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicInteger pendingLoads = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job timerJob;
    @org.jetbrains.annotations.Nullable()
    private android.animation.ValueAnimator starAnimator;
    private final int totalSeconds = 600;
    private int remainingSeconds;
    private int remainingSecondsOnPause;
    private boolean hasNavigatedToSuccess = false;
    private boolean scrollPartAfterRandom = false;
    private boolean hasTriggeredReInit = false;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_TEMPLATE_INDEX = "template_index";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_SELECTIONS = "selections";
    @org.jetbrains.annotations.NotNull()
    public static final com.anime.oc.characters.avatar.ui.main.show.ShowActivity.Companion Companion = null;
    
    public ShowActivity() {
        super(null, null);
    }
    
    private final com.anime.oc.characters.avatar.ui.main.customize.NavAdapter getAdapterNav() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.customize.ColorAdapter getAdapterColor() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.customize.PartAdapter getAdapterPart() {
        return null;
    }
    
    private final boolean isOnlineTemplate() {
        return false;
    }
    
    private final boolean checkOnlineNetworkOrShowDialog() {
        return false;
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    private final void updateTimerUI(int minutes, int seconds) {
    }
    
    private final void startTimer(int fromSeconds) {
    }
    
    private final void showFailLayout() {
    }
    
    private final void startCountDown() {
    }
    
    private final void readArgsAndInit() {
    }
    
    private final void setupAdapters() {
    }
    
    private final void navigateToSuccess() {
    }
    
    private final void doNavigateToSuccess() {
    }
    
    private final android.graphics.Bitmap renderLayersToBitmap() {
        return null;
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    private final void updateCompletionDialog(boolean isComplete) {
    }
    
    private final void showResultDialog(boolean isComplete) {
    }
    
    private final void showWinLayout() {
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    private final void buildLayerViews(java.util.List<com.anime.oc.characters.avatar.data.model.custom.BodyPartModel> parts) {
    }
    
    private final void renderLayers(com.anime.oc.characters.avatar.ui.main.show.ShowState state) {
    }
    
    private final void loadImageIntoView(android.widget.ImageView view, java.lang.String path) {
    }
    
    private final void onLoadFinished() {
    }
    
    private final void updateAdapters(com.anime.oc.characters.avatar.ui.main.show.ShowState state) {
    }
    
    private final java.util.List<java.lang.String> buildThumbList(com.anime.oc.characters.avatar.data.model.custom.BodyPartModel bp, java.util.List<java.lang.String> paths) {
        return null;
    }
    
    private final void updateMatchUI(int percent) {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/show/ShowActivity$Companion;", "", "()V", "ARG_SELECTIONS", "", "ARG_TEMPLATE_INDEX", "newArgshow", "Landroid/os/Bundle;", "templateIndex", "", "targetSelections", "Ljava/util/ArrayList;", "Lcom/anime/oc/characters/avatar/data/model/custom/SelectionIndex;", "Lkotlin/collections/ArrayList;", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Bundle newArgshow(int templateIndex, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.anime.oc.characters.avatar.data.model.custom.SelectionIndex> targetSelections) {
            return null;
        }
    }
}