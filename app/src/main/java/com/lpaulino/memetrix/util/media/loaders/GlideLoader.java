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
import com.lpaulino.memetrix.data.source.SourceCallback;
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
    public void loadWebImage(String url, ImageView imageView, int placeHolder, Transformation transformation, SourceCallback<Drawable> callback) {
        Context context = imageView.getContext();
        loadImage(context, Glide.with(context).load(url), placeHolder, transformation, callback).into(imageView);
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
    public void loadLocalImage(String path, ImageView imageView, int placeHolder, Transformation transformation, SourceCallback<Drawable> callback) {
        Context context = imageView.getContext();
        loadImage(context, Glide.with(context).load(new File(path)), placeHolder, transformation, callback).into(imageView);
    }

    private <T> DrawableTypeRequest<T> loadImage(
            Context context,
            DrawableTypeRequest<T> request,
            int placeholder,
            Transformation transformation,
            final SourceCallback<Drawable> callback) {
        request.fitCenter();
        int imagePlaceHolder = (placeholder != Constants.NO_RESOURCE) ? placeholder : android.R.color.darker_gray;
        request.placeholder(imagePlaceHolder);
        if (transformation != null) {
            switch (transformation) {
                case CIRCLE: request.bitmapTransform(new GlideCircleTransformation(context));
                    break;
            }
        }
        if (callback != null) {
            request.listener(new RequestListener<T, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, T model, Target<GlideDrawable> target, boolean isFirstResource) {
                    callback.onFailure(e);
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, T model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    callback.onSuccess(resource);
                    return false;
                }
            });
        }
        return request;
    }
}
