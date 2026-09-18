package com.duomaker.couplelove.vatar.ui.main.add_character;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u008f\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u008f\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J8\u0010N\u001a\u00020*2\u0006\u0010O\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u00020!2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\u0010\b\u0002\u0010S\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0002J\b\u0010T\u001a\u00020*H\u0002J\b\u0010U\u001a\u00020*H\u0016J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020X0WH\u0002J\u0010\u0010Y\u001a\u00020!2\u0006\u0010O\u001a\u00020\u001cH\u0002J\u0012\u0010Z\u001a\u00020*2\b\b\u0002\u0010[\u001a\u00020!H\u0002J\b\u0010\\\u001a\u00020*H\u0002J\b\u0010]\u001a\u00020*H\u0002J\b\u0010^\u001a\u00020*H\u0002J\b\u0010_\u001a\u00020*H\u0002J\b\u0010`\u001a\u00020!H\u0014J\u0012\u0010a\u001a\u00020*2\b\b\u0002\u0010b\u001a\u00020!H\u0002J\b\u0010c\u001a\u00020*H\u0003J\u0018\u0010d\u001a\u00020*2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020fH\u0002J\b\u0010h\u001a\u00020*H\u0002J\b\u0010i\u001a\u00020*H\u0002J\u0018\u0010j\u001a\u00020*2\u0006\u0010k\u001a\u00020f2\u0006\u0010g\u001a\u00020fH\u0002J\u0018\u0010l\u001a\u00020*2\u0006\u0010O\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020fH\u0002J\u0010\u0010m\u001a\u00020*2\u0006\u0010O\u001a\u00020\u001cH\u0002J\u0018\u0010n\u001a\u00020*2\u0006\u0010k\u001a\u00020f2\u0006\u0010g\u001a\u00020fH\u0002J\b\u0010o\u001a\u00020*H\u0002J\u000e\u0010p\u001a\b\u0012\u0004\u0012\u00020q0WH\u0002J\b\u0010r\u001a\u00020*H\u0002J\b\u0010s\u001a\u00020*H\u0002J\b\u0010t\u001a\u00020*H\u0002J\b\u0010u\u001a\u00020*H\u0002J\b\u0010v\u001a\u00020*H\u0016J\b\u0010w\u001a\u00020*H\u0002J\u000e\u0010x\u001a\b\u0012\u0004\u0012\u00020y0WH\u0002J\b\u0010z\u001a\u00020*H\u0002J\b\u0010{\u001a\u00020*H\u0016J\b\u0010|\u001a\u00020*H\u0014J\b\u0010}\u001a\u00020*H\u0002J\b\u0010~\u001a\u00020*H\u0002J\b\u0010\u007f\u001a\u00020*H\u0002J\u0012\u0010\u0080\u0001\u001a\u00020*2\u0007\u0010\u0081\u0001\u001a\u00020fH\u0002J\t\u0010\u0082\u0001\u001a\u00020*H\u0002J\t\u0010\u0083\u0001\u001a\u00020*H\u0002J\u0012\u0010\u0084\u0001\u001a\u00020*2\u0007\u0010\u0085\u0001\u001a\u00020fH\u0002J\u0012\u0010\u0086\u0001\u001a\u00020*2\u0007\u0010\u0085\u0001\u001a\u00020fH\u0002J\u001c\u0010\u0087\u0001\u001a\u00020*2\u0011\b\u0002\u0010\u0088\u0001\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0002J-\u0010\u0089\u0001\u001a\u00020*2\u000f\u0010\u008a\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u00012\u0011\b\u0002\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0002J\t\u0010\u008e\u0001\u001a\u00020*H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010\n\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010\n\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010\n\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010\n\u001a\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bK\u0010L\u00a8\u0006\u0090\u0001"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/add_character/AddCharacterActivity;", "Lcom/duomaker/couplelove/vatar/core/base/BaseActivity;", "Lcom/duomaker/couplelove/vatar/databinding/ActivityAddCharacterBinding;", "Lcom/duomaker/couplelove/vatar/ui/main/add_character/AddCharacterViewModel;", "()V", "backgroundColorAdapter", "Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/BackgroundColorAdapter;", "getBackgroundColorAdapter", "()Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/BackgroundColorAdapter;", "backgroundColorAdapter$delegate", "Lkotlin/Lazy;", "backgroundImageAdapter", "Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/BackgroundImageAdapter;", "getBackgroundImageAdapter", "()Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/BackgroundImageAdapter;", "backgroundImageAdapter$delegate", "backgroundSubmitJob", "Lkotlinx/coroutines/Job;", "imageManager", "Lcom/duomaker/couplelove/vatar/data/datalocal/manager/CharacterImageManager;", "getImageManager", "()Lcom/duomaker/couplelove/vatar/data/datalocal/manager/CharacterImageManager;", "setImageManager", "(Lcom/duomaker/couplelove/vatar/data/datalocal/manager/CharacterImageManager;)V", "imagePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "imagepath", "", "getImagepath", "()Ljava/lang/String;", "imagepath$delegate", "isCatalogUiReady", "", "isInitialCatalogReady", "isInitialCharacterReady", "isInitialScreenLoading", "isKeyboardOpen", "keyboardLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "pendingBackgroundReady", "Lkotlin/Function0;", "", "permissionViewModel", "Lcom/duomaker/couplelove/vatar/ui/onboarding/permission/PermissionViewModel;", "getPermissionViewModel", "()Lcom/duomaker/couplelove/vatar/ui/onboarding/permission/PermissionViewModel;", "permissionViewModel$delegate", "speechAdapter", "Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/SpeechAdapter;", "getSpeechAdapter", "()Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/SpeechAdapter;", "speechAdapter$delegate", "speechCategoryAdapter", "Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/SpeechCategoryAdapter;", "getSpeechCategoryAdapter", "()Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/SpeechCategoryAdapter;", "speechCategoryAdapter$delegate", "stickerAdapter", "Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/StickerAdapter;", "getStickerAdapter", "()Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/StickerAdapter;", "stickerAdapter$delegate", "stickerCategoryAdapter", "Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/StickerCategoryAdapter;", "getStickerCategoryAdapter", "()Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/StickerCategoryAdapter;", "stickerCategoryAdapter$delegate", "textColorAdapter", "Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/TextColorAdapter;", "getTextColorAdapter", "()Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/TextColorAdapter;", "textColorAdapter$delegate", "textFontAdapter", "Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/TextFontAdapter;", "getTextFontAdapter", "()Lcom/duomaker/couplelove/vatar/ui/main/add_character/adapter/TextFontAdapter;", "textFontAdapter$delegate", "addDrawable", "path", "isCharacter", "bitmapText", "Landroid/graphics/Bitmap;", "onDone", "applySelectedTextStyle", "bindViewModel", "buttonNavigationList", "Ljava/util/ArrayList;", "Landroid/widget/FrameLayout;", "checkNetworkBeforeRemoteAsset", "clearFocus", "check", "collapseKeyboard", "confirmExit", "confirmReset", "dispatchBackgroundReady", "handleBackPressed", "handleChooseColor", "isTextColor", "handleDoneText", "handleFontClick", "font", "", "position", "handleRemoveBackground", "handleSave", "handleSetBackgroundColor", "color", "handleSetBackgroundImage", "handleSpeech", "handleTextColorClick", "hideInitialLoadingWhenReady", "imageNavigationList", "Landroid/widget/ImageView;", "initActionBar", "initData", "initDrawView", "initRcv", "initView", "launchImagePicker", "layoutNavigationList", "Landroid/view/ViewGroup;", "loadCatalogAfterFirstFrame", "observeData", "onDestroy", "onKeyboardClose", "onKeyboardOpen", "restoreUIState", "setFlFunctionTopMargin", "margin", "setupKeyboardListener", "setupKeyboardListenerLegacy", "setupTypeBackground", "type", "setupTypeNavigation", "submitAllAdapters", "onBackgroundReady", "submitBackgroundImages", "items", "", "Lcom/duomaker/couplelove/vatar/data/model/addcharacter/SelectedAddModel;", "onFirstPageReady", "viewListener", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class AddCharacterActivity extends com.duomaker.couplelove.vatar.core.base.BaseActivity<com.duomaker.couplelove.vatar.databinding.ActivityAddCharacterBinding, com.duomaker.couplelove.vatar.ui.main.add_character.AddCharacterViewModel> {
    @javax.inject.Inject()
    public com.duomaker.couplelove.vatar.data.datalocal.manager.CharacterImageManager imageManager;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private android.view.ViewTreeObserver.OnGlobalLayoutListener keyboardLayoutListener;
    private boolean isCatalogUiReady = false;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job backgroundSubmitJob;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> pendingBackgroundReady;
    private boolean isInitialScreenLoading = false;
    private boolean isInitialCharacterReady = false;
    private boolean isInitialCatalogReady = false;
    private boolean isKeyboardOpen = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy backgroundImageAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy stickerCategoryAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy speechCategoryAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy backgroundColorAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy stickerAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy speechAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy textFontAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy textColorAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy imagepath$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> imagePickerLauncher = null;
    @java.lang.Deprecated()
    public static final int NONE_BACKGROUND_POSITION = 0;
    @java.lang.Deprecated()
    public static final int ADD_BACKGROUND_POSITION = 1;
    @java.lang.Deprecated()
    public static final int NONE_BACKGROUND_COLOR_POSITION = 0;
    @java.lang.Deprecated()
    public static final int CUSTOM_BACKGROUND_COLOR_POSITION = 1;
    @java.lang.Deprecated()
    public static final int BACKGROUND_BATCH_SIZE = 5;
    @java.lang.Deprecated()
    public static final int BACKGROUND_FIRST_PAGE_SIZE = 20;
    @java.lang.Deprecated()
    public static final long BACKGROUND_BATCH_DELAY_MS = 32L;
    @org.jetbrains.annotations.NotNull()
    private static final com.duomaker.couplelove.vatar.ui.main.add_character.AddCharacterActivity.Companion Companion = null;
    
    public AddCharacterActivity() {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.duomaker.couplelove.vatar.data.datalocal.manager.CharacterImageManager getImageManager() {
        return null;
    }
    
    public final void setImageManager(@org.jetbrains.annotations.NotNull()
    com.duomaker.couplelove.vatar.data.datalocal.manager.CharacterImageManager p0) {
    }
    
    private final com.duomaker.couplelove.vatar.ui.onboarding.permission.PermissionViewModel getPermissionViewModel() {
        return null;
    }
    
    private final com.duomaker.couplelove.vatar.ui.main.add_character.adapter.BackgroundImageAdapter getBackgroundImageAdapter() {
        return null;
    }
    
    private final com.duomaker.couplelove.vatar.ui.main.add_character.adapter.StickerCategoryAdapter getStickerCategoryAdapter() {
        return null;
    }
    
    private final com.duomaker.couplelove.vatar.ui.main.add_character.adapter.SpeechCategoryAdapter getSpeechCategoryAdapter() {
        return null;
    }
    
    private final com.duomaker.couplelove.vatar.ui.main.add_character.adapter.BackgroundColorAdapter getBackgroundColorAdapter() {
        return null;
    }
    
    private final com.duomaker.couplelove.vatar.ui.main.add_character.adapter.StickerAdapter getStickerAdapter() {
        return null;
    }
    
    private final com.duomaker.couplelove.vatar.ui.main.add_character.adapter.SpeechAdapter getSpeechAdapter() {
        return null;
    }
    
    private final com.duomaker.couplelove.vatar.ui.main.add_character.adapter.TextFontAdapter getTextFontAdapter() {
        return null;
    }
    
    private final com.duomaker.couplelove.vatar.ui.main.add_character.adapter.TextColorAdapter getTextColorAdapter() {
        return null;
    }
    
    private final java.lang.String getImagepath() {
        return null;
    }
    
    private final java.util.ArrayList<android.widget.FrameLayout> buttonNavigationList() {
        return null;
    }
    
    private final java.util.ArrayList<android.widget.ImageView> imageNavigationList() {
        return null;
    }
    
    private final java.util.ArrayList<android.view.ViewGroup> layoutNavigationList() {
        return null;
    }
    
    @java.lang.Override()
    public void observeData() {
    }
    
    @java.lang.Override()
    public void bindViewModel() {
    }
    
    @java.lang.Override()
    public void viewListener() {
    }
    
    /**
     * Chặn tải asset online khi thiết bị không có mạng.
     */
    private final boolean checkNetworkBeforeRemoteAsset(java.lang.String path) {
        return false;
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    /**
     * Source of truth duy nhất cho keyboard state và flFunction position.
     *
     * Logic:
     * - Keyboard lên (heightDiff > THRESHOLD):
     *    → Tab Text + speech dialog không mở → set bottomMargin = -170dp (cố định)
     *    → Các tab khác hoặc speech dialog đang mở → giữ nguyên (margin = 0)
     * - Keyboard xuống (heightDiff < -THRESHOLD):
     *    → Luôn reset margin = 0, bất kể tab nào
     */
    private final void setupKeyboardListener() {
    }
    
    private final void setupKeyboardListenerLegacy() {
    }
    
    private final void onKeyboardOpen() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void onKeyboardClose() {
    }
    
    private final void setFlFunctionTopMargin(int margin) {
    }
    
    /**
     * Đóng keyboard và reset view.
     * Dùng ở mọi nơi cần dismiss keyboard — backpress, click ngoài, done text, tab switch.
     */
    private final void collapseKeyboard() {
    }
    
    private final void clearFocus(boolean check) {
    }
    
    private final void initActionBar() {
    }
    
    private final void initRcv() {
    }
    
    private final void initData() {
    }
    
    private final void loadCatalogAfterFirstFrame() {
    }
    
    private final void submitAllAdapters(kotlin.jvm.functions.Function0<kotlin.Unit> onBackgroundReady) {
    }
    
    private final void submitBackgroundImages(java.util.List<com.duomaker.couplelove.vatar.data.model.addcharacter.SelectedAddModel> items, kotlin.jvm.functions.Function0<kotlin.Unit> onFirstPageReady) {
    }
    
    private final void dispatchBackgroundReady() {
    }
    
    private final void hideInitialLoadingWhenReady() {
    }
    
    private final void restoreUIState() {
    }
    
    private final void applySelectedTextStyle() {
    }
    
    private final void initDrawView() {
    }
    
    private final void addDrawable(java.lang.String path, boolean isCharacter, android.graphics.Bitmap bitmapText, kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    private final void setupTypeBackground(int type) {
    }
    
    private final void setupTypeNavigation(int type) {
    }
    
    private final void confirmExit() {
    }
    
    private final void confirmReset() {
    }
    
    private final void handleSetBackgroundImage(java.lang.String path, int position) {
    }
    
    private final void handleSetBackgroundColor(int color, int position) {
    }
    
    private final void handleRemoveBackground() {
    }
    
    private final void launchImagePicker() {
    }
    
    private final void handleChooseColor(boolean isTextColor) {
    }
    
    private final void handleSpeech(java.lang.String path) {
    }
    
    private final void handleFontClick(int font, int position) {
    }
    
    private final void handleTextColorClick(int color, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    private final void handleDoneText() {
    }
    
    private final void handleSave() {
    }
    
    /**
     * Logic backpress:
     * - Keyboard đang mở → đóng keyboard, KHÔNG back
     * - Keyboard đóng → hiện confirm dialog
     */
    @java.lang.Override()
    protected boolean handleBackPressed() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/duomaker/couplelove/vatar/ui/main/add_character/AddCharacterActivity$Companion;", "", "()V", "ADD_BACKGROUND_POSITION", "", "BACKGROUND_BATCH_DELAY_MS", "", "BACKGROUND_BATCH_SIZE", "BACKGROUND_FIRST_PAGE_SIZE", "CUSTOM_BACKGROUND_COLOR_POSITION", "NONE_BACKGROUND_COLOR_POSITION", "NONE_BACKGROUND_POSITION", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}