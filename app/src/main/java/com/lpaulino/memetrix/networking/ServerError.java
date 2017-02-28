package com.lpaulino.memetrix.networking;

import com.google.gson.annotations.SerializedName;

/**
 * @author Luis Alonso Paulino Flores on 28/02/17.
 */

public class ServerError {

    public static final int UNKNOWN = -999;
    public static final int CANCELLED = -1000;

    @SerializedName("code")
    private int mCode;

    @SerializedName("message")
    private String mMessage;

    public ServerError(int code, String message) {
        mCode = code;
        mMessage = message;
    }

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        return mMessage;
    }

    public Exception createException(Throwable cause) {
        if (cause != null) {
            return new Exception(mMessage, cause);
        }
        return new Exception(mMessage);
    }
}
