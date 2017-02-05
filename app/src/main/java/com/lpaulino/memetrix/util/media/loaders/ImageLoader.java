package com.lpaulino.memetrix.util.media.loaders;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.lpaulino.memetrix.data.source.SourceCallback;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public interface ImageLoader {

    enum Transformation {
        CIRCLE,
    }

    public void loadWebImage(String url, ImageView imageView);

    public void loadWebImage(String url, ImageView imageView, int placeHolder);

    public void loadWebImage(String url, ImageView imageView, int placeHolder, Transformation transformation);

    public void loadWebImage(String url, ImageView imageView, int placeHolder, Transformation transformation, SourceCallback<Drawable> callback);

    public void loadLocalImage(String path, ImageView imageView);

    public void loadLocalImage(String path, ImageView imageView, int placeHolder);

    public void loadLocalImage(String path, ImageView imageView, int placeHolder, Transformation transformation);

    public void loadLocalImage(String path, ImageView imageView, int placeHolder, Transformation transformation, SourceCallback<Drawable> callback);
}
