package com.anime.oc.characters.avatar.utils.share.whatsapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0018*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001\u0018B\'\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0015J\b\u0010\u0017\u001a\u00020\rH\u0002\u00a8\u0006\u0019"}, d2 = {"Lcom/anime/oc/characters/avatar/utils/share/whatsapp/WhatsappSharingActivity;", "VB", "Landroidx/viewbinding/ViewBinding;", "VM", "Landroidx/lifecycle/ViewModel;", "Lcom/anime/oc/characters/avatar/core/base/BaseActivity;", "bindingInflater", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "viewModelClass", "Ljava/lang/Class;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Class;)V", "addStickerPackageToWhatsApp", "", "sp", "Lcom/anime/oc/characters/avatar/utils/share/whatsapp/StickerPack;", "addToWhatsapp", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "showErrorDialog", "Companion", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
public abstract class WhatsappSharingActivity<VB extends androidx.viewbinding.ViewBinding, VM extends androidx.lifecycle.ViewModel> extends com.anime.oc.characters.avatar.core.base.BaseActivity<VB, VM> {
    private static final int ADD_PACK_REQUEST = 200;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXTRA_STICKER_PACK_ID = "sticker_pack_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXTRA_STICKER_PACK_AUTHORITY = "sticker_pack_authority";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXTRA_STICKER_PACK_NAME = "sticker_pack_name";
    private static final int MIN_STICKERS_REQUIRED = 3;
    @org.jetbrains.annotations.NotNull()
    public static final com.anime.oc.characters.avatar.utils.share.whatsapp.WhatsappSharingActivity.Companion Companion = null;
    
    public WhatsappSharingActivity(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.LayoutInflater, ? extends VB> bindingInflater, @org.jetbrains.annotations.NotNull()
    java.lang.Class<VM> viewModelClass) {
        super(null, null);
    }
    
    public final void addToWhatsapp(@org.jetbrains.annotations.NotNull()
    com.anime.oc.characters.avatar.utils.share.whatsapp.StickerPack sp) {
    }
    
    @java.lang.Override()
    @java.lang.Deprecated()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void addStickerPackageToWhatsApp(com.anime.oc.characters.avatar.utils.share.whatsapp.StickerPack sp) {
    }
    
    private final void showErrorDialog() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/anime/oc/characters/avatar/utils/share/whatsapp/WhatsappSharingActivity$Companion;", "", "()V", "ADD_PACK_REQUEST", "", "EXTRA_STICKER_PACK_AUTHORITY", "", "EXTRA_STICKER_PACK_ID", "EXTRA_STICKER_PACK_NAME", "MIN_STICKERS_REQUIRED", "ST279_Anime_OC_Maker_Avatar_Creator_v1.0.0_09.11.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}