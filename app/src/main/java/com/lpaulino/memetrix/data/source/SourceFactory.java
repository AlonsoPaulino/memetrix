package com.lpaulino.memetrix.data.source;

import com.lpaulino.memetrix.data.ImageLoader;
import com.lpaulino.memetrix.data.source.remote.GlideLoader;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class SourceFactory {

    public static ImageLoader createImageLoader() {
        return new GlideLoader();
    }
}
