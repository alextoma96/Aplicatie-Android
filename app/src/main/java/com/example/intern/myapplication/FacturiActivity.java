package com.example.intern.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Commons.Factura;
import Networking.HttpConnection;
import Utils.Constant;

public class FacturiActivity extends AppCompatActivity implements Constant{

    ListView lvFacturi;
    ArrayList<Factura> listaFacturi = new ArrayList<>();
    //private static final String url = "http://10.0.2.2:8080/kepres2Web/api/rs/factura/list";
    private static final String url = "https://api.myjson.com/bins/1979j1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturi);
        consumeHttpConnection();
    }

    public void initComponents() {
        lvFacturi = (ListView) findViewById(R.id.lista_lv_facturi);
        ArrayAdapter<Factura> adapter = new ArrayAdapter<Factura>(getApplicationContext(), android.R.layout.simple_list_item_1, listaFacturi);
        lvFacturi.setAdapter(adapter);

        lvFacturi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), FacturaDetailsActivity.class);
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
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_lvfacturi), Toast.LENGTH_SHORT).show();
                }
            }
        };
        connection.execute(url);
    }

}
