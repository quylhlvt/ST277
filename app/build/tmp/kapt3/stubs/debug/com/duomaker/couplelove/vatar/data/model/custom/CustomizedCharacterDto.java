package com.duomaker.couplelove.vatar.data.model.custom;

/**
 * DTO nhẹ — chỉ lưu vào customized.json.
 * listPath KHÔNG lưu — reconstruct từ template khi cần.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0014J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\fH\u00c6\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u00c6\u0003J\t\u0010)\u001a\u00020\u0012H\u00c6\u0003J\t\u0010*\u001a\u00020\u0012H\u00c6\u0003J\u0081\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u00c6\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020\u000fH\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001bR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018\u00a8\u00060"}, d2 = {"Lcom/duomaker/couplelove/vatar/data/model/custom/CustomizedCharacterDto;", "", "id", "", "templateId", "avatar", "selections", "Ljava/util/ArrayList;", "Lcom/duomaker/couplelove/vatar/data/model/custom/SelectionIndex;", "Lkotlin/collections/ArrayList;", "imageSave", "isFlipped", "", "layerTransforms", "", "", "Lcom/duomaker/couplelove/vatar/data/model/custom/LayerTransform;", "updatedAt", "", "createdAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;ZLjava/util/Map;JJ)V", "getAvatar", "()Ljava/lang/String;", "getCreatedAt", "()J", "getId", "getImageSave", "()Z", "getLayerTransforms", "()Ljava/util/Map;", "getSelections", "()Ljava/util/ArrayList;", "getTemplateId", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class CustomizedCharacterDto {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String templateId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String avatar = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex> selections = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String imageSave = null;
    private final boolean isFlipped = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Integer, com.duomaker.couplelove.vatar.data.model.custom.LayerTransform> layerTransforms = null;
    private final long updatedAt = 0L;
    private final long createdAt = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, com.duomaker.couplelove.vatar.data.model.custom.LayerTransform> component7() {
        return null;
    }
    
    public final long component8() {
        return 0L;
    }
    
    public final long component9() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.duomaker.couplelove.vatar.data.model.custom.CustomizedCharacterDto copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String templateId, @org.jetbrains.annotations.NotNull()
    java.lang.String avatar, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex> selections, @org.jetbrains.annotations.NotNull()
    java.lang.String imageSave, boolean isFlipped, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Integer, com.duomaker.couplelove.vatar.data.model.custom.LayerTransform> layerTransforms, long updatedAt, long createdAt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public CustomizedCharacterDto(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String templateId, @org.jetbrains.annotations.NotNull()
    java.lang.String avatar, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex> selections, @org.jetbrains.annotations.NotNull()
    java.lang.String imageSave, boolean isFlipped, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Integer, com.duomaker.couplelove.vatar.data.model.custom.LayerTransform> layerTransforms, long updatedAt, long createdAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTemplateId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAvatar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex> getSelections() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImageSave() {
        return null;
    }
    
    public final boolean isFlipped() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, com.duomaker.couplelove.vatar.data.model.custom.LayerTransform> getLayerTransforms() {
        return null;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public CustomizedCharacterDto() {
        super();
    }
}