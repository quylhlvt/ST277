package com.duomaker.couplelove.vatar.data.datalocal.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/duomaker/couplelove/vatar/data/datalocal/api/AvatarApiService;", "", "getAllData", "", "", "", "Lcom/duomaker/couplelove/vatar/data/datalocal/api/X10;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ST283_Duo_Maker_Couple_Avatar_v1.0.0_09.18.2026_debug"})
public abstract interface AvatarApiService {
    
    @retrofit2.http.GET(value = "api/app/ST283_DuoMakerCoupleAvatar")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.util.List<com.duomaker.couplelove.vatar.data.datalocal.api.X10>>> $completion);
}