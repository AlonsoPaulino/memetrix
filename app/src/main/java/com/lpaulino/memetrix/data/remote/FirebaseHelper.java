package com.lpaulino.memetrix.data.remote;

import com.google.firebase.auth.FirebaseAuth;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class FirebaseHelper {

    private FirebaseHelper() {}

    public static FirebaseAuth getFirebaseAuthInstance() {
        return FirebaseAuth.getInstance();
    }
}
