package com.example.customviews;

import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Android on 13.04.2016.
 */
public class ViewCreator {

    public static View createView(ViewGroup parent, @IdRes int id) {
        TextView view = new TextView(parent.getContext());
        view.setId(id);
        return view;
    }

}
