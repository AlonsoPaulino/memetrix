package com.lpaulino.memetrix.domain;

import com.google.gson.annotations.SerializedName;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class User {

    private static final String USER_DEFAULT = "meme@belatrixsf.com";
    private static final String PASSWORD_DEFAULT = "fis";
    private static final String PROFILE_IMAGE_DEFAULT = "http://hackatrix.belatrixsf.com/2016_arg/media/logo_belahacka_top.png";

    @SerializedName("user-token")
    private String token;
    private String email;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("profile_image")
    private String profileImage;

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getProfileImage() {
        return PROFILE_IMAGE_DEFAULT;
    }
}
