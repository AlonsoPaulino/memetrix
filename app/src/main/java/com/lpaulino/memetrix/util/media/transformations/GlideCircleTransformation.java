package com.lpaulino.memetrix.util.media.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class GlideCircleTransformation implements Transformation<Bitmap> {

    private BitmapPool mBitmapPool;

    public GlideCircleTransformation(Context context) {
        mBitmapPool = Glide.get(context).getBitmapPool();
    }

    @Override
    public Resource<Bitmap> transform(Resource<Bitmap> resource, int outWidth, int outHeight) {
        Bitmap bitmap = resource.get();
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (bitmap.getWidth() - size) >> 1;
        int height = (bitmap.getHeight() - size) >> 1;

        Bitmap bitmapTransformed = mBitmapPool.get(size, size, Bitmap.Config.ARGB_8888);

        if (bitmapTransformed == null) {
            bitmapTransformed = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        }

        Paint paint = new Paint();
        BitmapShader bitmapShader = new BitmapShader(bitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);

        if (width != 0 || height != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-width, -height);
            bitmapShader.setLocalMatrix(matrix);
        }

        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);

        float radio = size >> 1;

        new Canvas(bitmapTransformed).drawCircle(radio, radio, radio, paint);
        return BitmapResource.obtain(bitmapTransformed, mBitmapPool);
    }

    @Override
    public String getId() {
        return "MemetrixImageCircleTransformation";
    }
}
