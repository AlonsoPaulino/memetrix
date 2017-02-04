package com.lpaulino.memetrix.domain;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class User {

    private static final String USER_DEFAULT = "meme@belatrixsf.com";
    private static final String PASSWORD_DEFAULT = "fis";

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isAuthorized() {
        return username != null && password != null && username.equals(USER_DEFAULT) && password.equals(PASSWORD_DEFAULT);
    }

    public String getUsername() {
        return username;
    }
}
