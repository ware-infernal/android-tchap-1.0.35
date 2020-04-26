package org.matrix.androidsdk.rest.model;

import com.google.gson.annotations.SerializedName;

public class MediaScanPublicKeyResult {
    @SerializedName("public_key")
    public String mCurve25519PublicKey;
}
