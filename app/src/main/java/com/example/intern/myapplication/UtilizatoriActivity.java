package com.example.intern.myapplication;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Commons.Factura;
import Commons.Utilizator;
import Networking.HttpConnectionFacturi;
import Networking.HttpConnectionUtilizatori;
import Utils.Constant;

public class UtilizatoriActivity extends Fragment implements Constant {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        consumeHttpConnection();
        return inflater.inflate(R.layout.activity_utilizatori, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Utilizatori");
    }

    ListView lvUtilizatori;
    ArrayList<Utilizator> listaUtilizatori = new ArrayList<>();

    public void initComponents() {
        lvUtilizatori = (ListView) getActivity().findViewById(R.id.lista_lv_utilizatori);
        ArrayAdapter<Utilizator> adapter = new ArrayAdapter<Utilizator>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, listaUtilizatori);
        lvUtilizatori.setAdapter(adapter);
    }

    public void consumeHttpConnection() {
        HttpConnectionUtilizatori connection = new HttpConnectionUtilizatori() {
            @Override
            protected void onPostExecute(ArrayList<Utilizator> utilizators) {
                initComponents();
                super.onPostExecute(utilizators);
                if (utilizators != null) {
                    listaUtilizatori.addAll(utilizators);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), getResources().getString(R.string.toast_lvUtilizatori), Toast.LENGTH_SHORT).show();
                }
            }
        };
        connection.execute("http://" + PreferenceManager.getDefaultSharedPreferences(getContext()).getString("ip", "192.168.8.98") + "/kepres203/api/rs/utilizator/list");
    }
}
