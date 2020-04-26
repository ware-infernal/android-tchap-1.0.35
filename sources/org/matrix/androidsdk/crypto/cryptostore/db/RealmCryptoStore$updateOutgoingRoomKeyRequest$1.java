package org.matrix.androidsdk.crypto.cryptostore.db;

import io.realm.Realm;
import io.realm.RealmModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.matrix.androidsdk.crypto.OutgoingRoomKeyRequest;
import org.matrix.androidsdk.crypto.cryptostore.db.model.OutgoingRoomKeyRequestEntity;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lio/realm/Realm;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: RealmCryptoStore.kt */
final class RealmCryptoStore$updateOutgoingRoomKeyRequest$1 extends Lambda implements Function1<Realm, Unit> {
    final /* synthetic */ OutgoingRoomKeyRequest $request;

    RealmCryptoStore$updateOutgoingRoomKeyRequest$1(OutgoingRoomKeyRequest outgoingRoomKeyRequest) {
        this.$request = outgoingRoomKeyRequest;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Realm) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Realm realm) {
        Intrinsics.checkParameterIsNotNull(realm, "it");
        OutgoingRoomKeyRequestEntity outgoingRoomKeyRequestEntity = new OutgoingRoomKeyRequestEntity(null, null, null, null, null, null, null, 0, 255, null);
        outgoingRoomKeyRequestEntity.setRequestId(this.$request.mRequestId);
        outgoingRoomKeyRequestEntity.setCancellationTxnId(this.$request.mCancellationTxnId);
        outgoingRoomKeyRequestEntity.setState(this.$request.mState.ordinal());
        outgoingRoomKeyRequestEntity.putRecipients(this.$request.mRecipients);
        outgoingRoomKeyRequestEntity.putRequestBody(this.$request.mRequestBody);
        realm.insertOrUpdate((RealmModel) outgoingRoomKeyRequestEntity);
    }
}