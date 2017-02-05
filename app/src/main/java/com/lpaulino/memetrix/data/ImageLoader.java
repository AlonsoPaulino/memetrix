package com.lpaulino.memetrix.data;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.lpaulino.memetrix.data.source.SourceCallback;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public interface ImageLoader {

    void loadWebImage(String url, ImageView imageView);

    void loadWebImage(String url, ImageView imageView, int placeHolder);

    void loadWebImage(String url, ImageView imageView, int placeHolder, SourceCallback<Drawable> callback);

    void loadLocalImage(String path, ImageView imageView);

    void loadLocalImage(String path, ImageView imageView, SourceCallback<Drawable> callback);
}
