package com.lpaulino.memetrix.networking.requests;

import com.google.gson.annotations.SerializedName;

/**
 * @author Luis Alonso Paulino Flores on 7/03/17.
 */

public class RegistrationBody {

    private String email;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String password;

    public RegistrationBody(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
}
