package com.example.customviews.custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.customviews.R;

/**
 * Created by Android on 17.02.2016.
 */
public class CompoundView extends LinearLayout {

    public CompoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater.from(context).inflate(R.layout.compound_view_layout, this);
    }



}
