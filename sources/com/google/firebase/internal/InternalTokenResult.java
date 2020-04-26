package com.google.firebase.internal;

import com.google.android.gms.common.internal.Objects;
import im.vector.activity.VectorUniversalLinkActivity;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
public class InternalTokenResult {
    private String zza;

    public InternalTokenResult(String str) {
        this.zza = str;
    }

    public String getToken() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InternalTokenResult)) {
            return false;
        }
        return Objects.equal(this.zza, ((InternalTokenResult) obj).zza);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(VectorUniversalLinkActivity.KEY_MAIL_VALIDATION_TOKEN, this.zza).toString();
    }
}
