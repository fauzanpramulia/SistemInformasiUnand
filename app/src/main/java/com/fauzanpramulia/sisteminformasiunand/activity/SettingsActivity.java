package com.fauzanpramulia.sisteminformasiunand.activity;

import android.os.Bundle;

import com.fauzanpramulia.sisteminformasiunand.R;
import com.fauzanpramulia.sisteminformasiunand.fragment.SettingsFragment;

public class SettingsActivity extends android.support.v7.app.AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new SettingsFragment())
                .commit();

    }
}
