package com.lpaulino.memetrix.domain;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class User {

    private static final String USER_DEFAULT = "meme@belatrixsf.com";
    private static final String PASSWORD_DEFAULT = "fis";
    private static final String PROFILE_IMAGE_DEFAULT = "http://hackatrix.belatrixsf.com/2016_arg/media/logo_belahacka_top.png";

    private String username;
    private String profileImage;

    public User(String username) {
        this.username = username;
        this.profileImage = PROFILE_IMAGE_DEFAULT;
    }

    public boolean isAuthorized(String password) {
        return username != null && password != null && username.equals(USER_DEFAULT) && password.equals(PASSWORD_DEFAULT);
    }

    public String getUsername() {
        return username;
    }

    public String getProfileImage() {
        return profileImage;
    }
}
