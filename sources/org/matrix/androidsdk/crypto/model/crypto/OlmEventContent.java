package org.matrix.androidsdk.crypto.model.crypto;

import java.io.Serializable;
import java.util.Map;

public class OlmEventContent implements Serializable {
    public Map<String, Object> ciphertext;
    public String sender_key;
}
