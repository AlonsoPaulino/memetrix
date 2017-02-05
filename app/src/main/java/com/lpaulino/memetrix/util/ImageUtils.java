package com.lpaulino.memetrix.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class ImageUtils {

    public static void loadImage(Context context, String url, ImageView imageView) {
        ImageUtils.loadImage(context, url, imageView, android.R.color.darker_gray);
    }

    public static void loadImage(Context context, String url, ImageView imageView, int placeholder) {
        Glide.with(context).load(url).placeholder(placeholder).into(imageView);
    }
}
