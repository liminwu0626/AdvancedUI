package com.whty.advancedui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.whty.advancedui.R;

/**
 * Created by wulimin on 2017/5/16.
 */

public class CircleProgressBar extends View {
    private int max;
    private int roundColor;
    private int roundProgressColor;
    private int textColor;
    private float textSize;
    private float roundWidth;
    private boolean textShow;
    private int progress;
    private Paint mPaint;
    private static final int STROKE = 0;
    private static final int FILL = 1;

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);
        max = typedArray.getInteger(R.styleable.CustomProgressBar_max, 100);
        roundColor = typedArray.getColor(R.styleable.CustomProgressBar_roundColor, Color.RED);
        roundProgressColor = typedArray.getColor(R.styleable.CustomProgressBar_roundProgressColor, Color.BLUE);
        textColor = typedArray.getColor(R.styleable.CustomProgressBar_textColor, Color.GREEN);
        textSize = typedArray.getDimension(R.styleable.CustomProgressBar_textSize, 55);
        roundWidth = typedArray.getDimension(R.styleable.CustomProgressBar_roundWidth, 10);
        textShow = typedArray.getBoolean(R.styleable.CustomProgressBar_textShow, true);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画背景圆环
        int center = getWidth() / 2;
        float radius = center - roundWidth / 2;
        mPaint.setColor(roundColor);
        mPaint.setStrokeWidth(roundWidth);//圆环的宽度
        mPaint.setAntiAlias(true);
        canvas.drawCircle(center, center, radius, mPaint);
        //画进度百分比
        mPaint.setColor(textColor);
        mPaint.setStrokeWidth(0);
        mPaint.setTextSize(textSize);
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        int percent = (int) (progress / (float) max * 100);
        String strPercent = percent + "%";
        Paint.FontMetricsInt fontMetricsInt = mPaint.getFontMetricsInt();
        if (percent != 0) {
            canvas.drawText(strPercent, getWidth() / 2 - mPaint.measureText(strPercent) / 2, getWidth() / 2 + (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom, mPaint);
        }
        //画圆弧
        RectF oval = new RectF(center - radius, center - radius, center + radius, center + radius);
        mPaint.setColor(roundProgressColor);
        mPaint.setStrokeWidth(roundWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(oval, 0, 360 * progress / max, false, mPaint);
    }

    public void setProgress(int progress) {
        if (progress < 0) {
            throw new IllegalArgumentException("进度Progress不能小于0");
        }
        if (progress > max) {
            progress = max;
        }
        if (progress <= max) {
            this.progress = progress;
            postInvalidate();
        }
    }
}
