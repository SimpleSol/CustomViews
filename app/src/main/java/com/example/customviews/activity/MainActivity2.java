package com.example.customviews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.customviews.R;
import com.example.customviews.custom_views.CompoundView2;
import com.example.customviews.dialog.ChangeDescDialog;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Android on 17.02.2016.
 */
public class MainActivity2 extends AppCompatActivity implements CompoundView2.CompoundClickListener,
        ChangeDescDialog.OnTextChangedListener{

    @Bind(R.id.compound_view_2)
    CompoundView2 mCompoundView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        ButterKnife.bind(this);
        mCompoundView2.setCompoundClickListener(this);
    }

    @Override
    public void onEditButtonClick() {
        ChangeDescDialog.newInstance(this).show(getFragmentManager(), ChangeDescDialog.class.getName());
    }

    @Override
    public void setNewDescription(String newDescription) {
        mCompoundView2.setDescription(newDescription);
    }
}
