package com.lpaulino.memetrix.presentation.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixFragment;
import com.lpaulino.memetrix.presentation.tems.TermsActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class SignUpFragment extends MemetrixFragment implements SignUpContract.View {

    @BindView(R.id.first_name_edit_text) EditText mFirstNameEditText;
    @BindView(R.id.last_name_edit_text) EditText mLastNameEditText;
    @BindView(R.id.email_edit_text) EditText mEmailEditText;
    @BindView(R.id.password_edit_text) EditText mPasswordEditText;
    @BindView(R.id.accept_terms_and_conditions_button) Button mAcceptTermsAndConditionsButton;

    private SignUpContract.Presenter mPresenter;

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentListener.setToolbarTitle(getString(R.string.sign_up));
    }

    @OnClick(R.id.accept_button)
    public void onAcceptButtonClicked(Button acceptButton) {
        String email = mEmailEditText.getText().toString().trim();
        String firstName = mFirstNameEditText.getText().toString().trim();
        String lastName = mLastNameEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString();
        mPresenter.register(email, firstName, lastName, password);
    }

    @OnClick(R.id.accept_terms_and_conditions_button)
    public void onAcceptTermsAndConditionsButtonClicked(View view) {
        startActivity(new Intent(mContext, TermsActivity.class));
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(mContext, Constants.MAIN_ACTIVITY));
    }

    @Override
    public void setPresenter(SignUpContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
