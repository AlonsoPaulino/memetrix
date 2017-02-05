package com.lpaulino.memetrix.util.media.loaders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.util.media.transformations.GlideCircleTransformation;

import java.io.File;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class GlideLoader implements ImageLoader {

    @Override
    public void loadWebImage(String url, ImageView imageView) {
        loadWebImage(url, imageView, Constants.NO_RESOURCE, null, null);
    }

    @Override
    public void loadWebImage(String url, ImageView imageView, int placeHolder) {
        loadWebImage(url, imageView, placeHolder, null, null);
    }

    @Override
    public void loadWebImage(String url, ImageView imageView, int placeHolder, Transformation transformation) {
        loadWebImage(url, imageView, placeHolder, transformation, null);
    }

    @Override
    public void loadWebImage(String url, ImageView imageView, int placeHolder, Transformation transformation, SuccessCallback<Drawable> successCallback) {
        loadWebImage(url, imageView, placeHolder, transformation, successCallback, null);
    }

    @Override
    public void loadWebImage(String url, ImageView imageView, int placeHolder, Transformation transformation, SuccessCallback<Drawable> successCallback, ErrorCallback errorCallback) {
        Context context = imageView.getContext();
        loadImage(context, Glide.with(context).load(url), placeHolder, transformation, successCallback, errorCallback).into(imageView);
    }

    @Override
    public void loadLocalImage(String path, ImageView imageView) {
        loadLocalImage(path, imageView, Constants.NO_RESOURCE, null, null);
    }

    @Override
    public void loadLocalImage(String path, ImageView imageView, int placeHolder) {
        loadLocalImage(path, imageView, placeHolder, null, null);
    }

    @Override
    public void loadLocalImage(String path, ImageView imageView, int placeHolder, Transformation transformation) {
        loadLocalImage(path, imageView, placeHolder, transformation, null);
    }

    @Override
    public void loadLocalImage(String path, ImageView imageView, int placeHolder, Transformation transformation, SuccessCallback<Drawable> successCallback) {
        loadLocalImage(path, imageView, placeHolder, transformation, successCallback, null);
    }

    @Override
    public void loadLocalImage(String path, ImageView imageView, int placeHolder, Transformation transformation, SuccessCallback<Drawable> successCallback, ErrorCallback errorCallback) {
        Context context = imageView.getContext();
        loadImage(context, Glide.with(context).load(new File(path)), placeHolder, transformation, successCallback, errorCallback).into(imageView);
    }

    private <T> DrawableTypeRequest<T> loadImage(
            Context context,
            DrawableTypeRequest<T> request,
            int placeholder,
            Transformation transformation,
            final SuccessCallback<Drawable> successCallback,
            final ErrorCallback errorCallback) {
        request.fitCenter();
        int imagePlaceHolder = (placeholder != Constants.NO_RESOURCE) ? placeholder : android.R.color.darker_gray;
        request.placeholder(imagePlaceHolder);
        if (transformation != null) {
            switch (transformation) {
                case CIRCLE: request.bitmapTransform(new GlideCircleTransformation(context));
                    break;
            }
        }
        request.listener(new RequestListener<T, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, T model, Target<GlideDrawable> target, boolean isFirstResource) {
                if (errorCallback != null) {
                    errorCallback.onError(e);
                }
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, T model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                if (successCallback != null) {
                    successCallback.onSuccess(resource);
                }
                return false;
            }
        });
        return request;
    }
}
