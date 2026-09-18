package com.duomaker.couplelove.vatar.data.datalocal.manager;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001a\u00020\u000fJ\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/duomaker/couplelove/vatar/data/datalocal/manager/CharacterImageManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imagesDir", "Ljava/io/File;", "getImagesDir", "()Ljava/io/File;", "imagesDir$delegate", "Lkotlin/Lazy;", "cleanupOrphanedImages", "", "existingCharacterIds", "", "", "deleteImage", "", "imagePath", "deleteOldImage", "characterId", "getTotalStorageSize", "", "loadBitmap", "Landroid/graphics/Bitmap;", "saveBitmap", "bitmap", "Companion", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class CharacterImageManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "CharacterImageManager";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String IMAGES_DIR = "character_images";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy imagesDir$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.data.datalocal.manager.CharacterImageManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public CharacterImageManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final java.io.File getImagesDir() {
        return null;
    }
    
    /**
     * Lưu bitmap thành file PNG
     * @return Absolute path của file đã lưu
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String saveBitmap(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    java.lang.String characterId) {
        return null;
    }
    
    /**
     * Load bitmap từ file path
     */
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap loadBitmap(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath) {
        return null;
    }
    
    /**
     * Xóa file ảnh
     */
    public final boolean deleteImage(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath) {
        return false;
    }
    
    /**
     * Xóa ảnh cũ của character trước khi save ảnh mới
     */
    public final void deleteOldImage(@org.jetbrains.annotations.NotNull()
    java.lang.String characterId) {
    }
    
    /**
     * Cleanup: Xóa tất cả ảnh của các character không còn tồn tại
     */
    public final void cleanupOrphanedImages(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> existingCharacterIds) {
    }
    
    /**
     * Lấy tổng dung lượng ảnh đã lưu
     */
    public final long getTotalStorageSize() {
        return 0L;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/duomaker/couplelove/vatar/data/datalocal/manager/CharacterImageManager$Companion;", "", "()V", "IMAGES_DIR", "", "TAG", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}