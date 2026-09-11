package com.anime.oc.characters.avatar.ui.main.add_character;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 \u0080\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0080\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J8\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001a2\b\b\u0002\u0010H\u001a\u00020\u001f2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010LH\u0002J\b\u0010M\u001a\u00020FH\u0002J\b\u0010N\u001a\u00020FH\u0016J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PH\u0002J\u0010\u0010R\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u001aH\u0002J\u0012\u0010S\u001a\u00020F2\b\b\u0002\u0010T\u001a\u00020\u001fH\u0002J\b\u0010U\u001a\u00020FH\u0002J\b\u0010V\u001a\u00020FH\u0002J\b\u0010W\u001a\u00020FH\u0002J\b\u0010X\u001a\u00020\u001fH\u0014J\u0012\u0010Y\u001a\u00020F2\b\b\u0002\u0010Z\u001a\u00020\u001fH\u0002J\b\u0010[\u001a\u00020FH\u0003J\u0018\u0010\\\u001a\u00020F2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020^H\u0002J\b\u0010`\u001a\u00020FH\u0002J\b\u0010a\u001a\u00020FH\u0002J\u0018\u0010b\u001a\u00020F2\u0006\u0010c\u001a\u00020^2\u0006\u0010_\u001a\u00020^H\u0002J\u0018\u0010d\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020^H\u0002J\u0010\u0010e\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001aH\u0002J\u0018\u0010f\u001a\u00020F2\u0006\u0010c\u001a\u00020^2\u0006\u0010_\u001a\u00020^H\u0002J\b\u0010g\u001a\u00020FH\u0002J\u000e\u0010h\u001a\b\u0012\u0004\u0012\u00020i0PH\u0002J\b\u0010j\u001a\u00020FH\u0002J\b\u0010k\u001a\u00020FH\u0002J\b\u0010l\u001a\u00020FH\u0002J\b\u0010m\u001a\u00020FH\u0002J\b\u0010n\u001a\u00020FH\u0016J\b\u0010o\u001a\u00020FH\u0002J\u000e\u0010p\u001a\b\u0012\u0004\u0012\u00020q0PH\u0002J\b\u0010r\u001a\u00020FH\u0016J\b\u0010s\u001a\u00020FH\u0014J\b\u0010t\u001a\u00020FH\u0002J\b\u0010u\u001a\u00020FH\u0002J\b\u0010v\u001a\u00020FH\u0002J\u0010\u0010w\u001a\u00020F2\u0006\u0010x\u001a\u00020^H\u0002J\b\u0010y\u001a\u00020FH\u0002J\b\u0010z\u001a\u00020FH\u0002J\u0010\u0010{\u001a\u00020F2\u0006\u0010|\u001a\u00020^H\u0002J\u0010\u0010}\u001a\u00020F2\u0006\u0010|\u001a\u00020^H\u0002J\b\u0010~\u001a\u00020FH\u0002J\b\u0010\u007f\u001a\u00020FH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b$\u0010%R\u001b\u0010\'\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\n\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010\n\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010\n\u001a\u0004\b8\u00109R\u001b\u0010;\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010\n\u001a\u0004\bB\u0010C\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/add_character/AddCharacterActivity;", "Lcom/anime/oc/characters/avatar/core/base/BaseActivity;", "Lcom/anime/oc/characters/avatar/databinding/ActivityAddCharacterBinding;", "Lcom/anime/oc/characters/avatar/ui/main/add_character/AddCharacterViewModel;", "()V", "backgroundColorAdapter", "Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/BackgroundColorAdapter;", "getBackgroundColorAdapter", "()Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/BackgroundColorAdapter;", "backgroundColorAdapter$delegate", "Lkotlin/Lazy;", "backgroundImageAdapter", "Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/BackgroundImageAdapter;", "getBackgroundImageAdapter", "()Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/BackgroundImageAdapter;", "backgroundImageAdapter$delegate", "imageManager", "Lcom/anime/oc/characters/avatar/data/datalocal/manager/CharacterImageManager;", "getImageManager", "()Lcom/anime/oc/characters/avatar/data/datalocal/manager/CharacterImageManager;", "setImageManager", "(Lcom/anime/oc/characters/avatar/data/datalocal/manager/CharacterImageManager;)V", "imagePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "imagepath", "", "getImagepath", "()Ljava/lang/String;", "imagepath$delegate", "isKeyboardOpen", "", "keyboardLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "permissionViewModel", "Lcom/anime/oc/characters/avatar/ui/onboarding/permission/PermissionViewModel;", "getPermissionViewModel", "()Lcom/anime/oc/characters/avatar/ui/onboarding/permission/PermissionViewModel;", "permissionViewModel$delegate", "speechAdapter", "Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/SpeechAdapter;", "getSpeechAdapter", "()Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/SpeechAdapter;", "speechAdapter$delegate", "speechCategoryAdapter", "Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/SpeechCategoryAdapter;", "getSpeechCategoryAdapter", "()Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/SpeechCategoryAdapter;", "speechCategoryAdapter$delegate", "stickerAdapter", "Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/StickerAdapter;", "getStickerAdapter", "()Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/StickerAdapter;", "stickerAdapter$delegate", "stickerCategoryAdapter", "Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/StickerCategoryAdapter;", "getStickerCategoryAdapter", "()Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/StickerCategoryAdapter;", "stickerCategoryAdapter$delegate", "textColorAdapter", "Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/TextColorAdapter;", "getTextColorAdapter", "()Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/TextColorAdapter;", "textColorAdapter$delegate", "textFontAdapter", "Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/TextFontAdapter;", "getTextFontAdapter", "()Lcom/anime/oc/characters/avatar/ui/main/add_character/adapter/TextFontAdapter;", "textFontAdapter$delegate", "addDrawable", "", "path", "isCharacter", "bitmapText", "Landroid/graphics/Bitmap;", "onDone", "Lkotlin/Function0;", "applySelectedTextStyle", "bindViewModel", "buttonNavigationList", "Ljava/util/ArrayList;", "Landroid/widget/FrameLayout;", "checkNetworkBeforeRemoteAsset", "clearFocus", "check", "collapseKeyboard", "confirmExit", "confirmReset", "handleBackPressed", "handleChooseColor", "isTextColor", "handleDoneText", "handleFontClick", "font", "", "position", "handleRemoveBackground", "handleSave", "handleSetBackgroundColor", "color", "handleSetBackgroundImage", "handleSpeech", "handleTextColorClick", "hideLoadingAfterFirstFrame", "imageNavigationList", "Landroid/widget/ImageView;", "initActionBar", "initData", "initDrawView", "initRcv", "initView", "launchImagePicker", "layoutNavigationList", "Landroid/view/ViewGroup;", "observeData", "onDestroy", "onKeyboardClose", "onKeyboardOpen", "restoreUIState", "setFlFunctionTopMargin", "margin", "setupKeyboardListener", "setupKeyboardListenerLegacy", "setupTypeBackground", "type", "setupTypeNavigation", "submitAllAdapters", "viewListener", "Companion", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public final class AddCharacterActivity extends com.anime.oc.characters.avatar.core.base.BaseActivity<com.anime.oc.characters.avatar.databinding.ActivityAddCharacterBinding, com.anime.oc.characters.avatar.ui.main.add_character.AddCharacterViewModel> {
    @javax.inject.Inject()
    public com.anime.oc.characters.avatar.data.datalocal.manager.CharacterImageManager imageManager;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy permissionViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private android.view.ViewTreeObserver.OnGlobalLayoutListener keyboardLayoutListener;
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
    public static final int ADD_BACKGROUND_POSITION = 0;
    @java.lang.Deprecated()
    public static final int NONE_BACKGROUND_POSITION = 1;
    @java.lang.Deprecated()
    public static final int CUSTOM_BACKGROUND_COLOR_POSITION = 0;
    @org.jetbrains.annotations.NotNull()
    private static final com.anime.oc.characters.avatar.ui.main.add_character.AddCharacterActivity.Companion Companion = null;
    
    public AddCharacterActivity() {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.anime.oc.characters.avatar.data.datalocal.manager.CharacterImageManager getImageManager() {
        return null;
    }
    
    public final void setImageManager(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.data.datalocal.manager.CharacterImageManager p0) {
    }
    
    private final com.anime.oc.characters.avatar.ui.onboarding.permission.PermissionViewModel getPermissionViewModel() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.add_character.adapter.BackgroundImageAdapter getBackgroundImageAdapter() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.add_character.adapter.StickerCategoryAdapter getStickerCategoryAdapter() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.add_character.adapter.SpeechCategoryAdapter getSpeechCategoryAdapter() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.add_character.adapter.BackgroundColorAdapter getBackgroundColorAdapter() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.add_character.adapter.StickerAdapter getStickerAdapter() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.add_character.adapter.SpeechAdapter getSpeechAdapter() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.add_character.adapter.TextFontAdapter getTextFontAdapter() {
        return null;
    }
    
    private final com.anime.oc.characters.avatar.ui.main.add_character.adapter.TextColorAdapter getTextColorAdapter() {
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
    
    /**
     * Giữ loading từ màn Custom cho tới khi màn Background đã sẵn sàng vẽ.
     * post sau pre-draw bảo đảm frame chứa character/background được render trước
     * khi dialog loading biến mất.
     */
    private final void hideLoadingAfterFirstFrame() {
    }
    
    private final void submitAllAdapters() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/anime/oc/characters/avatar/ui/main/add_character/AddCharacterActivity$Companion;", "", "()V", "ADD_BACKGROUND_POSITION", "", "CUSTOM_BACKGROUND_COLOR_POSITION", "NONE_BACKGROUND_POSITION", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}