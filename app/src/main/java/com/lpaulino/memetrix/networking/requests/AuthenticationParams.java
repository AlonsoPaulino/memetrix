package com.lpaulino.memetrix.networking.requests;

/**
 * @author Luis Alonso Paulino Flores on 27/02/17.
 */

public class AuthenticationParams {

    private String username;
    private String password;

    public AuthenticationParams(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
