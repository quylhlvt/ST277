package com.duomaker.couplelove.vatar.core.helper;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J)\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/duomaker/couplelove/vatar/core/helper/JsonFileHelper;", "", "()V", "FILE_NAME", "", "gson", "Lcom/google/gson/Gson;", "clear", "", "context", "Landroid/content/Context;", "getFile", "Ljava/io/File;", "loadCharacters", "T", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "(Landroid/content/Context;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;", "saveCharacters", "data", "", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public final class JsonFileHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FILE_NAME = "characters.json";
    @org.jetbrains.annotations.NotNull()
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.duomaker.couplelove.vatar.core.helper.JsonFileHelper INSTANCE = null;
    
    private JsonFileHelper() {
        super();
    }
    
    private final java.io.File getFile(android.content.Context context) {
        return null;
    }
    
    public final void saveCharacters(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> data) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>T loadCharacters(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.google.gson.reflect.TypeToken<T> typeToken) {
        return null;
    }
    
    public final void clear(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}