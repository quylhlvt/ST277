package com.duomaker.couplelove.vatar.ui.main.show;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0000\u00a8\u0006\b"}, d2 = {"calculateMatchPercent", "", "parts", "", "Lcom/duomaker/couplelove/vatar/data/model/custom/BodyPartModel;", "target", "Lcom/duomaker/couplelove/vatar/data/model/custom/SelectionIndex;", "user", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class ShowViewModelKt {
    
    /**
     * Mỗi nav chỉ có điểm khi cả màu và part cùng khớp đáp án. Part được UI chọn sẵn
     * vẫn được chấm ngay. Target "none"/"dice" hoặc hỏng được bỏ khỏi mẫu số để 100%
     * luôn có thể đạt được.
     */
    public static final int calculateMatchPercent(@org.jetbrains.annotations.NotNull()
    java.util.List<com.duomaker.couplelove.vatar.data.model.custom.BodyPartModel> parts, @org.jetbrains.annotations.NotNull()
    java.util.List<com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex> target, @org.jetbrains.annotations.NotNull()
    java.util.List<com.duomaker.couplelove.vatar.data.model.custom.SelectionIndex> user) {
        return 0;
    }
}