package com.example.intern.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Commons.Utilizator;
import Networking.HttpConnectionUtilizatori;
import Utils.Constant;

public class LoginActivity extends AppCompatActivity implements Constant{

    private EditText etusername;
    private EditText etpassword;
    private CheckBox cbrmbrcred;

    String users=null;
    String pass=null;
    Integer id=null;

    List<Utilizator> userList = null;

    private SharedPreferences preferenceSettings;
    private SharedPreferences.Editor preferenceEditor;

    private String USERNAME_PREFERENCE_KEY="username";
    private String PASSWORD_PREFERENCE_KEY="password";
    private String CHECKBOX_PREFERENCE_KEY="checkbox";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        etusername = (EditText) findViewById(R.id.et_login_username);
        etpassword = (EditText) findViewById(R.id.et_login_password);
        cbrmbrcred = (CheckBox) findViewById(R.id.cb_login_remember);
        boolean cb;
        if(cbrmbrcred.isChecked()){
            cb=true;
        }else{
            cb=false;
        }
        preferenceSettings = getSharedPreferences(PREFERENCE_FILE, PREFERENCE_MODE_PRIVATE);
        preferenceEditor = preferenceSettings.edit();
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();
        boolean preferenceCb=preferenceSettings.getBoolean(CHECKBOX_PREFERENCE_KEY, cb);
        String preferenceUsername = preferenceSettings.getString(USERNAME_PREFERENCE_KEY, username);
        String preferencePassword = preferenceSettings.getString(PASSWORD_PREFERENCE_KEY, password);
        Log.d(preferenceUsername, preferencePassword);
        if (preferenceUsername != null && preferencePassword != null && preferenceCb==true) {
            etusername.setText(preferenceUsername);
            etpassword.setText(preferencePassword);
            cbrmbrcred.setChecked(true);
        }
    }

    public void logInActivity(View v){
        final boolean cb;
        if(v.getId()==R.id.btn_login_button){
            if(cbrmbrcred.isChecked()){
                cb=true;
            }else{
                cb=false;
            }
            final String username=etusername.getText().toString();
            final String password=etpassword.getText().toString();
            if(validation(username, password)){
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                preferenceEditor.putBoolean(CHECKBOX_PREFERENCE_KEY, cb);
                preferenceEditor.putString(USERNAME_PREFERENCE_KEY, username);
                preferenceEditor.putString(PASSWORD_PREFERENCE_KEY, password);
                boolean successfulSave = preferenceEditor.commit();
            } else{
                Toast.makeText(this,R.string.login_toast2, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean validation(String u, String p) {
        consumeHttpConnection();
        for (Utilizator user : userList) {
            if (u.equals(user.getUsername()) && p.equals(user.getParola())) {
                users=user.getUsername();
                pass=user.getParola();
            }
        }
        if(users!=null && pass!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public void consumeHttpConnection() {
        HttpConnectionUtilizatori connection = new HttpConnectionUtilizatori() {
            @Override
            protected void onPostExecute(ArrayList<Utilizator> utilizators) {
                super.onPostExecute(utilizators);
                if (utilizators != null) {
                    userList.addAll(utilizators);
                }
                for(Utilizator u : userList) {
                    Log.i("user", u.getNume());
                }
            }
        };
        connection.execute("http://" + PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("ip", "192.168.8.98") + "/kepres203/api/rs/utilizator/list");
    }
}