package com.example.customviews.custom_views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 15.02.2016.
 */
public class SimpleDrawingView extends View {

    private final int mPaintColor = Color.BLACK;
    private Paint mDrawPaint;
    private List<Point> mCirclePoints;
    private Path mPath;

    public SimpleDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
        mCirclePoints = new ArrayList<>();
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(mPath, mDrawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(pointX, pointY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }
        postInvalidate();
        return true;
    }

    public void clear() {
        mPath.reset();
        invalidate();
    }

    private void setupPaint() {
        mDrawPaint = new Paint();
        mDrawPaint.setStyle(Paint.Style.STROKE);
        mDrawPaint.setColor(mPaintColor);
        mDrawPaint.setAntiAlias(true);
        mDrawPaint.setStrokeWidth(5);
        mDrawPaint.setStrokeJoin(Paint.Join.ROUND);
        mDrawPaint.setStrokeCap(Paint.Cap.ROUND);
    }
}
