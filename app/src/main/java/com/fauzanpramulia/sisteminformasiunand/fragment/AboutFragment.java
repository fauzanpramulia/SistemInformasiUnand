package com.fauzanpramulia.sisteminformasiunand.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.fauzanpramulia.sisteminformasiunand.BuildConfig;
import com.fauzanpramulia.sisteminformasiunand.R;

public class AboutFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater dialogInflater = getActivity().getLayoutInflater();
        View aboutView = dialogInflater.inflate(R.layout.about_fragment, null);
        TextView prog = aboutView.findViewById(R.id.programer);
        prog.setText(getString(R.string.programer) + BuildConfig.VERSION_NAME);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setView(aboutView)
                .setTitle((getString(R.string.dialog_title_about)))
                .setNeutralButton(android.R.string.ok, null);

        return dialogBuilder.create();
    }
}
