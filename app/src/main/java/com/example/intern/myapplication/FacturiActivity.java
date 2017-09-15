package com.example.intern.myapplication;

import android.content.Intent;
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
import Networking.HttpConnection;
import Utils.Constant;



public class FacturiActivity extends Fragment implements Constant{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        consumeHttpConnection();
        return inflater.inflate(R.layout.activity_facturi, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Facturi");
    }

    ListView lvFacturi;
    ArrayList<Factura> listaFacturi = new ArrayList<>();


    public void initComponents() {
        lvFacturi = (ListView) getActivity().findViewById(R.id.lista_lv_facturi);
        ArrayAdapter<Factura> adapter = new ArrayAdapter<Factura>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, listaFacturi);
        lvFacturi.setAdapter(adapter);

        lvFacturi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity().getApplicationContext(), FacturaDetailsActivity.class);
                intent.putExtra(FACTURA_KEY, position);
                startActivity(intent);
            }
        });
    }

    public void consumeHttpConnection() {
        HttpConnection connection = new HttpConnection() {
            @Override
            protected void onPostExecute(ArrayList<Factura> facturas) {
                initComponents();
                super.onPostExecute(facturas);
                if(facturas != null) {
                    listaFacturi.addAll(facturas);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), getResources().getString(R.string.toast_lvfacturi), Toast.LENGTH_SHORT).show();
                }
            }
        };
       // connection.execute("http://" + ip + url);
    }

}
