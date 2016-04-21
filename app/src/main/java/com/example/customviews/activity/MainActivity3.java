package com.example.customviews.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.customviews.R;

/**
 * Created by Android on 13.04.2016.
 */
public class MainActivity3 extends AppCompatActivity {

    private static final String TAG = MainActivity3.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll_main_activity_3);
        LinearLayout ll2 = new LinearLayout(this);

        TextView textView = new TextView(this);
//        ll.addView(textView);
        Log.d(TAG, String.valueOf(ll2.getChildCount()));
    }
}
