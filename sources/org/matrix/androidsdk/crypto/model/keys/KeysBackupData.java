package org.matrix.androidsdk.crypto.model.keys;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lorg/matrix/androidsdk/crypto/model/keys/KeysBackupData;", "", "()V", "roomIdToRoomKeysBackupData", "", "", "Lorg/matrix/androidsdk/crypto/model/keys/RoomKeysBackupData;", "getRoomIdToRoomKeysBackupData", "()Ljava/util/Map;", "setRoomIdToRoomKeysBackupData", "(Ljava/util/Map;)V", "matrix-sdk-crypto_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: KeysBackupData.kt */
public final class KeysBackupData {
    @SerializedName("rooms")
    private Map<String, RoomKeysBackupData> roomIdToRoomKeysBackupData = new HashMap();

    public final Map<String, RoomKeysBackupData> getRoomIdToRoomKeysBackupData() {
        return this.roomIdToRoomKeysBackupData;
    }

    public final void setRoomIdToRoomKeysBackupData(Map<String, RoomKeysBackupData> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.roomIdToRoomKeysBackupData = map;
    }
}
