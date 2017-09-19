package com.example.intern.myapplication;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Commons.Factura;
import Commons.StatusFactura;
import Networking.HttpConnectionFacturi;
import Networking.HttpConnectionStatus;

public class StatusFacturaActivity extends Fragment {

    ListView lvStatus;
    ArrayList<StatusFactura> listaStatus = new ArrayList<>();
    ArrayList<Factura> listaFacturi = new ArrayList<>();
    ArrayList<StatusFactura> listaFinala = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        consumeHttpConnection();
        return inflater.inflate(R.layout.activity_status_factura, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Status factura");
    }
    public void initComponents() {
        lvStatus = (ListView) getActivity().findViewById(R.id.lista_lv_status);
        listaFinala = getListaStatus();
        ArrayAdapter<StatusFactura> adapter = new ArrayAdapter<StatusFactura>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, listaFinala);
        lvStatus.setAdapter(adapter);
    }

    public void consumeHttpConnection() {
        HttpConnectionStatus connection = new HttpConnectionStatus() {
            @Override
            protected void onPostExecute(ArrayList<StatusFactura> status) {
                initComponents();
                super.onPostExecute(status);
                if (status != null) {
                    listaStatus.addAll(status);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), getResources().getString(R.string.toast_lvStatus), Toast.LENGTH_SHORT).show();
                }
            }
        };
        connection.execute("http://" + PreferenceManager.getDefaultSharedPreferences(getContext()).getString("ip", "192.168.196.2:8080") + "/kepres2Web/api/rs/status/list");
    }

    public void getFacturi() {
        HttpConnectionFacturi connection = new HttpConnectionFacturi() {
            @Override
            protected void onPostExecute(ArrayList<Factura> facturi) {
                super.onPostExecute(facturi);
                initComponents();
                if (facturi != null) {
                    listaFacturi.addAll(facturi);
                }
            }
        };
        connection.execute("http://" + PreferenceManager.getDefaultSharedPreferences(getContext()).getString("ip", "192.168.196.2:8080") + "/kepres2Web/api/rs/factura/list");
    }

    public ArrayList<StatusFactura> getListaStatus() {
        int count;
        getFacturi();
        ArrayList<StatusFactura> list = new ArrayList<>();
        for(StatusFactura s : listaStatus) {
            if (!list.contains(s.getStatus())) {
                count = 0;
                for (Factura f : listaFacturi) {
                    if(f.getStatusFactura().getStatus().equals("DRAFT")) {
                        count ++;
                    }
                }

                StatusFactura status = new StatusFactura(s.getStatus(), count);
                Log.i("status", status.getStatus() + String.valueOf(count));
                list.add(status);
            }
        }
        return list;
    }
}
