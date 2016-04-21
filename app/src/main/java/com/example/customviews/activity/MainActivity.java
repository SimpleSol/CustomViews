package com.example.customviews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.customviews.R;
import com.example.customviews.custom_views.SimpleDrawingView;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Android on 15.02.2016.
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.simple_drawing_view)
    SimpleDrawingView mSimpleDrawingView;
    @Bind(R.id.linear_layout)
    LinearLayout mLinearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        RoundingParams roundingParams = RoundingParams.asCircle();
//        GenericDraweeHierarchy hierarchy =
//                new GenericDraweeHierarchyBuilder(getResources())
//                        .setRoundingParams(roundingParams)
//                        .build();
////        iv.setHierarchy(hierarchy);
//        SimpleDraweeView iv = new SimpleDraweeView(this, hierarchy);
//
//        mLinearLayout.addView(iv);

        ImageView iv = new ImageView(this);
        mLinearLayout.addView(iv);
        Picasso.with(this)
                .load("https://networklessons.com/wp-content/uploads/2013/02/stub-tree-150x150.jpg")
                .into(iv);



//        Uri uri = Uri.parse("https://networklessons.com/wp-content/uploads/2013/02/stub-tree-150x150.jpg");
//        iv.setImageURI(uri);
    }

    @OnClick(R.id.btn_clear)
    void onClick() {
        mSimpleDrawingView.clear();
    }

}
