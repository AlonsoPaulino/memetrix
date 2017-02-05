package com.lpaulino.memetrix.presentation.signin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.data.local.PreferencesHelper;
import com.lpaulino.memetrix.domain.User;
import com.lpaulino.memetrix.presentation.common.MemetrixFragment;
import com.lpaulino.memetrix.presentation.signup.SignUpActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class SignInFragment extends MemetrixFragment implements SignInContract.View, TextWatcher{

    @BindView(R.id.email_edit_text) EditText mEmailEditText;
    @BindView(R.id.password_edit_text) EditText mPasswordEditText;
    @BindView(R.id.sign_in_button) Button mSignInButton;

    private SignInContract.Presenter mPresenter;

    public static SignInFragment newInstance() {
        return new SignInFragment();
    }

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEmailEditText.addTextChangedListener(this);
        mPasswordEditText.addTextChangedListener(this);
        mSignInButton.setEnabled(false);
    }

    @OnClick(R.id.sign_in_button)
    public void onSignInButtonClicked(Button signInButton) {
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString();
        mPresenter.authenticate(email, password);
    }

    @OnClick(R.id.sign_up_button)
    public void onSignUpButtonClicked(Button signUpButton) {
        startActivity(new Intent(mContext, SignUpActivity.class));
    }

    @Override
    public void userIsAuthorized() {
        startActivity(new Intent(mContext, Constants.MAIN_ACTIVITY));
        mFragmentListener.dismissActivity();
    }

    @Override
    public void userIsUnauthorized(Exception exception) {
        mEmailEditText.setText("");
        mPasswordEditText.setText("");
        mEmailEditText.clearFocus();
        mPasswordEditText.clearFocus();
        showErrorMessage(exception);
    }

    @Override
    public void setPresenter(SignInContract.Presenter presenter) {
        mPresenter = presenter;
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
