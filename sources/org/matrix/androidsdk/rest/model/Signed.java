package org.matrix.androidsdk.rest.model;

import java.io.Serializable;

public class Signed implements Serializable {
    public String mxid;
    public Object signatures;
    public String token;
}
