package com.lpaulino.memetrix.networking.requests;

import com.google.gson.annotations.SerializedName;

/**
 * @author Luis Alonso Paulino Flores on 27/02/17.
 */

public class AuthenticationBody {

    @SerializedName("login")
    private String username;
    private String password;

    public AuthenticationBody(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
