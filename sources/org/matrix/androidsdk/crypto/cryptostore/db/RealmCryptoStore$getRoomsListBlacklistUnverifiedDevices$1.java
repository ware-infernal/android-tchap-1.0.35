package org.matrix.androidsdk.crypto.cryptostore.db;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.matrix.androidsdk.crypto.cryptostore.db.model.CryptoRoomEntity;
import org.matrix.androidsdk.crypto.cryptostore.db.model.CryptoRoomEntityFields;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/realm/RealmResults;", "Lorg/matrix/androidsdk/crypto/cryptostore/db/model/CryptoRoomEntity;", "kotlin.jvm.PlatformType", "it", "Lio/realm/Realm;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: RealmCryptoStore.kt */
final class RealmCryptoStore$getRoomsListBlacklistUnverifiedDevices$1 extends Lambda implements Function1<Realm, RealmResults<CryptoRoomEntity>> {
    public static final RealmCryptoStore$getRoomsListBlacklistUnverifiedDevices$1 INSTANCE = new RealmCryptoStore$getRoomsListBlacklistUnverifiedDevices$1();

    RealmCryptoStore$getRoomsListBlacklistUnverifiedDevices$1() {
        super(1);
    }

    public final RealmResults<CryptoRoomEntity> invoke(Realm realm) {
        Intrinsics.checkParameterIsNotNull(realm, "it");
        RealmQuery where = realm.where(CryptoRoomEntity.class);
        Intrinsics.checkExpressionValueIsNotNull(where, "this.where(T::class.java)");
        return where.equalTo(CryptoRoomEntityFields.BLACKLIST_UNVERIFIED_DEVICES, Boolean.valueOf(true)).findAll();
    }
}
