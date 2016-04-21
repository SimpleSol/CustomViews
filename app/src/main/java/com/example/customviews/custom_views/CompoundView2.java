package com.example.customviews.custom_views;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customviews.R;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by Android on 17.02.2016.
 */
public class CompoundView2 extends RelativeLayout implements Serializable, View.OnClickListener {

    private static final String SAVED_DESCRIPTION = "saved_description";
    private static final String STATE_SUPER_CLASS = "SuperClass";

    private ImageButton mButton;
    private TextView mDescription;
//    private CompoundClickListener mListener;

    private WeakReference<CompoundClickListener> mWeakListener;


    public CompoundView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_SUPER_CLASS, super.onSaveInstanceState());
        bundle.putString(SAVED_DESCRIPTION, mDescription.getText().toString());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER_CLASS));
            mDescription.setText(bundle.getString(SAVED_DESCRIPTION));
        } else {
            super.onRestoreInstanceState(state);
        }

    }

    private void initializeViews(final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.compound_view_layout_2, this, true);
        mDescription = (TextView) view.findViewById(R.id.cmp_2_text_description);
        mButton = (ImageButton) view.findViewById(R.id.btn_edit);
        mButton.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void setCompoundClickListener(CompoundClickListener listener) {
//        mListener = listener;
        mWeakListener = new WeakReference<>(listener, new ReferenceQueue<>());
    }

    public void setDescription(String description) {
        mDescription.setText(description);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_edit && mWeakListener.get() != null) {
            mWeakListener.get().onEditButtonClick();
        }
    }

    public interface CompoundClickListener {

        void onEditButtonClick();

    }
}



















