package com.lpaulino.memetrix.util.media;

import com.lpaulino.memetrix.util.media.loaders.GlideLoader;
import com.lpaulino.memetrix.util.media.loaders.ImageLoader;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class ImageFactory {

    private ImageFactory() {}

    public static ImageLoader createImageLoader() {
        return new GlideLoader();
    }
}
