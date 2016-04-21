package com.example.customviews.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;


/**
 * Created by Android on 17.02.2016.
 */
public class ChangeDescDialog extends DialogFragment {

    private OnTextChangedListener mListener;

    public static ChangeDescDialog newInstance(OnTextChangedListener listener) {
        ChangeDescDialog dialog = new ChangeDescDialog();
        dialog.mListener = listener;
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final EditText editText = new EditText(getActivity());
        return new AlertDialog.Builder(getActivity())
                .setView(editText)
                .setTitle("New Description")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.setNewDescription(editText.getText().toString());
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create();

    }

    public interface OnTextChangedListener {

        void setNewDescription(String newDescription);

    }

}
