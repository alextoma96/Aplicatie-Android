package com.example.intern.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class SettingsActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Settings");
        final EditText urlSet = (EditText) getActivity().findViewById(R.id.serverIP);
        urlSet.setText(PreferenceManager.getDefaultSharedPreferences(getContext()).getString("ip", "defaultStringIfNothingFound"));

        Button buton = (Button) getActivity().findViewById(R.id.button);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("ip", urlSet.getText().toString()).apply();
                startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
            }
        });

    }

}
