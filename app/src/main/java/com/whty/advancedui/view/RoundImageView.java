package com.whty.advancedui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.whty.advancedui.R;
/**
* @function RoundImageView
* @author wulimin
* @time 2017/5/16 下午5:30
*/


public class RoundImageView extends View {


    private Paint mBitMapPaint;

    private Bitmap mBitMapSRC, mBitMapDST;

    public RoundImageView(Context context) {
        this(context,null);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        mBitMapPaint = new Paint();
        mBitMapSRC = BitmapFactory.decodeResource(getResources(), R.drawable.xyjy6);
        mBitMapDST =BitmapFactory.decodeResource(getResources(),R.drawable.shade);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitMapDST,0,0,mBitMapPaint);
        mBitMapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mBitMapSRC,0,0,mBitMapPaint);

        mBitMapPaint.setXfermode(null);
    }
}
