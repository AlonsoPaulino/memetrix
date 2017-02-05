package com.lpaulino.memetrix.data.source.remote;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.data.ImageLoader;
import com.lpaulino.memetrix.data.source.SourceCallback;

import java.io.File;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class GlideLoader implements ImageLoader{

    @Override
    public void loadWebImage(String url, ImageView imageView) {
        loadWebImage(url, imageView, Constants.NO_RESOURCE);
    }

    @Override
    public void loadWebImage(String url, ImageView imageView, int placeHolder) {
        loadWebImage(url, imageView, placeHolder, null);
    }

    @Override
    public void loadWebImage(String url, ImageView imageView, int placeHolder, SourceCallback<String> callback) {
        Context context = imageView.getContext();
        loadImage(Glide.with(context).load(url), placeHolder, callback).into(imageView);
    }

    @Override
    public void loadLocalImage(String path, ImageView imageView) {
        loadLocalImage(path, imageView, null);
    }

    @Override
    public void loadLocalImage(String path, ImageView imageView, SourceCallback<String> callback) {
        Context context = imageView.getContext();
        loadImage(Glide.with(context).load(new File(path)), Constants.NO_RESOURCE, callback).into(imageView);
    }

    private <T> DrawableTypeRequest<T> loadImage(
            DrawableTypeRequest<T> request,
            int placeholder,
            final SourceCallback<String> callback) {
        request.fitCenter();
        int imagePlaceHolder = (placeholder != Constants.NO_RESOURCE) ? placeholder : android.R.color.darker_gray;
        request.placeholder(imagePlaceHolder);
        if (callback != null) {
            request.listener(new RequestListener<T, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, T model, Target<GlideDrawable> target, boolean isFirstResource) {
                    callback.onFailure(e);
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, T model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    callback.onSuccess("Success image loaded");
                    return false;
                }
            });
        }
        return request;
    }
}
