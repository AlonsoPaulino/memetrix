package com.lpaulino.memetrix.presentation.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixFragment;

import butterknife.BindView;

/**
 * @author Luis Alonso Paulino Flores on 04/02/17.
 */

public class TermsFragment extends MemetrixFragment {

    @BindView(R.id.web_content) WebView mWebView;

    public static TermsFragment newInstance() {
        return new TermsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_terms, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentListener.setToolbarTitle(getString(R.string.terms_and_conditions));
        mFragmentListener.showLoader();
        mWebView.setWebViewClient(new CustomWebViewClient());
        mWebView.loadUrl(Constants.TERMS_AND_CONDITIONS_URL);
    }

    private class CustomWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            dismissLoader();
        }
    }
}
