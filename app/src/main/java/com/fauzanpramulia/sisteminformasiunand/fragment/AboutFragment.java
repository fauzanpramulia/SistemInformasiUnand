package com.fauzanpramulia.sisteminformasiunand.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.fauzanpramulia.sisteminformasiunand.R;

public class AboutFragment extends android.support.v4.app.DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater dialogInflater = getActivity().getLayoutInflater();
        View aboutView = dialogInflater.inflate(R.layout.about_fragment, null);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setView(aboutView)
                .setTitle((getString(R.string.dialog_title_about)))
                .setNeutralButton(android.R.string.ok, null);

        return dialogBuilder.create();
    }
}
