package org.matrix.androidsdk.rest.model.message;

public class AudioMessage extends FileMessage {
    public AudioMessage() {
        this.msgtype = Message.MSGTYPE_AUDIO;
    }
}
