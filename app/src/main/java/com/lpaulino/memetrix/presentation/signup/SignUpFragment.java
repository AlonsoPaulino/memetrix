package com.lpaulino.memetrix.presentation.signup;

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

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class SignUpFragment extends MemetrixFragment {

    @BindView(R.id.first_name_edit_text) EditText mFirstNameEditText;
    @BindView(R.id.last_name_edit_text) EditText mLastNameEditText;
    @BindView(R.id.email_edit_text) EditText mEmailEditText;
    @BindView(R.id.accept_terms_and_conditions_button) Button mAcceptTermsAndConditionsButton;

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
        getActivity().onBackPressed();
    }

    @OnClick(R.id.accept_terms_and_conditions_button)
    public void onAcceptTermsAndConditionsButtonClicked(View view) {
        mFragmentListener.replaceFragment(TermsFragment.newInstance(), true);
    }
}
