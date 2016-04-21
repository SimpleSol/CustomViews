package com.example.customviews.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.customviews.R;

/**
 * Created by Android on 16.02.2016.
 */
public class ShapeSelectorView extends View {

    // Attributes variables
    private int mShapeColor;
    private boolean mDisplayShapeName;

    // Shape variables
    private Paint mPaintShape;
    private int mShapeWidth;
    private int mShapeHeight;
    private int mTextXOffset;
    private int mTextYOffset;

    // Shape toggle variables
    private String[] mShapeValues;
    private int mCurrentShapeIndex;

    public ShapeSelectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupAttributes(attrs);
        setupShape();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int textPadding = 10;
        int contentWidth = mShapeWidth;

        int minWidth = contentWidth + getPaddingLeft() + getPaddingRight();
        int w = resolveSizeAndState(minWidth, widthMeasureSpec, 0);

        int minHeight = mShapeHeight + getPaddingTop() + getPaddingBottom();
        if (mDisplayShapeName) {
            minHeight += mTextYOffset + textPadding;
        }
        int h = resolveSizeAndState(minHeight, heightMeasureSpec, 0);

        setMeasuredDimension(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String shapeSelected = mShapeValues[mCurrentShapeIndex];
        if (TextUtils.equals(shapeSelected, "square")) {
            canvas.drawRect(0, 0, mShapeWidth, mShapeHeight, mPaintShape);
            mTextXOffset = 0;
        } else if (TextUtils.equals(shapeSelected, "circle")) {
            canvas.drawCircle(mShapeWidth / 2, mShapeHeight / 2, mShapeWidth / 2, mPaintShape);
            mTextXOffset = 12;
        } else if (TextUtils.equals(shapeSelected, "triangle")) {
            canvas.drawPath(getTrianglePath(), mPaintShape);
            mTextXOffset = 0;
        }

        if (mDisplayShapeName) {
            canvas.drawText(shapeSelected, mTextXOffset, mShapeHeight + mTextYOffset, mPaintShape);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mCurrentShapeIndex =
                    mCurrentShapeIndex == mShapeValues.length - 1
                            ? 0
                            : mCurrentShapeIndex + 1;
            postInvalidate();
            return true;
        }
        return result;
    }

    private void setupAttributes(AttributeSet attrs) {
        TypedArray typedArray = getContext()
                .getTheme()
                .obtainStyledAttributes(attrs, R.styleable.ShapeSelectorView, 0, 0);
        try {
            mShapeColor = typedArray.getColor(R.styleable.ShapeSelectorView_shapeColor, Color.BLACK);
            mDisplayShapeName = typedArray.getBoolean(R.styleable.ShapeSelectorView_displayShapeName, false);
        } finally {
            typedArray.recycle();
        }
    }

    private void setupShape() {
        mPaintShape = new Paint();
        mPaintShape.setStyle(Paint.Style.FILL);
        mPaintShape.setColor(mShapeColor);
        mPaintShape.setTextSize(30);

        mShapeWidth = 100;
        mShapeHeight = 100;
        mTextXOffset = 0;
        mTextYOffset = 30;

        mShapeValues = new String[]{"square", "circle", "triangle"};
        mCurrentShapeIndex = 0;
    }

    protected Path getTrianglePath() {
        Point p1 = new Point(0, mShapeHeight);
        Point p2 = new Point(p1.x + mShapeWidth, p1.y);
        Point p3 = new Point(p1.x + (mShapeWidth / 2), p1.y - mShapeHeight);
        Path path = new Path();
        path.moveTo(p1.x, p1.y);
        path.lineTo(p2.x, p2.y);
        path.lineTo(p3.x, p3.y);
        return path;
    }

    public boolean isDisplayingShapeName() {
        return mDisplayShapeName;
    }

    public void setDisplayingShapeName(boolean state) {
        mDisplayShapeName = state;
        invalidate();
        requestLayout();
    }

    public int getShapeColor() {
        return mShapeColor;
    }

    public void setShapeColor(int color) {
        mShapeColor = color;
        invalidate();
        requestLayout();
    }

}





















