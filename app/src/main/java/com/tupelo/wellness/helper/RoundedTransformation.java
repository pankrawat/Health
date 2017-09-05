package com.tupelo.wellness.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

import com.koushikdutta.ion.bitmap.Transform;

/**
 * Created by owner on 21/07/16.
 */public class RoundedTransformation implements Transform {
    int margin = 0;
    int radius = 12;


    public Bitmap transform(final Bitmap source) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP));

        Bitmap output = Bitmap.createBitmap(source.getWidth(),
                source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.drawRoundRect(new RectF(margin, margin, source.getWidth()
                - margin, source.getHeight() - margin), radius, radius, paint);
        if (source != output) {
            source.recycle();
        }

        return output;
    }

    @Override
    public String key() {
        return "rounded";
    }

}
