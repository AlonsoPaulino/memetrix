package com.lpaulino.memetrix.presentation.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.data.local.PreferencesHelper;
import com.lpaulino.memetrix.domain.User;
import com.lpaulino.memetrix.presentation.about.AboutUsActivity;
import com.lpaulino.memetrix.presentation.common.MemetrixFragment;
import com.lpaulino.memetrix.presentation.memes.MemesActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class SignInFragment extends MemetrixFragment implements TextWatcher{

    @BindView(R.id.email_edit_text) EditText mEmailEditText;
    @BindView(R.id.password_edit_text) EditText mPasswordEditText;
    @BindView(R.id.sign_in_button) Button mSignInButton;

    public static SignInFragment newInstance() {
        return new SignInFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEmailEditText.addTextChangedListener(this);
        mPasswordEditText.addTextChangedListener(this);
        mSignInButton.setEnabled(false);
    }

    @OnClick(R.id.sign_in_button)
    public void onSignInButtonClicked(Button signInButton) {
        User user = new User(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
        if (user.isAuthorized()) {
            startActivity(new Intent(mContext, MemesActivity.class));
            //TODO: Server Authentication
            PreferencesHelper.setUserLoggedIn(user.getUsername());
            getActivity().finish();
        } else {
            showErrorMessage(new Exception(getString(R.string.message_error_invalid_credentials)));
        }
    }

    @OnClick(R.id.sign_up_button)
    public void onSignUpButtonClicked(Button signUpButton) {
        if (mFragmentListener != null) {
            mFragmentListener.replaceFragment(SignUpFragment.newInstance(), true);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        mSignInButton.setEnabled(!mEmailEditText.getText().toString().isEmpty() && !mPasswordEditText.getText().toString().isEmpty());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
