package Networking;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import Commons.StatusFactura;
import Utils.Constant;

/**
 * Created by idanciu on 9/19/2017.
 */

public class HttpConnectionStatus extends AsyncTask<String, Void, ArrayList<StatusFactura>> implements Constant {
    URL url;
    HttpURLConnection connection;

    @Override
    protected ArrayList<StatusFactura> doInBackground(String... params) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            url = new URL(params[0]);
            Log.i("url", url.toString());
            connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            return parseHttpResponse(stringBuilder.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<StatusFactura> parseHttpResponse(String JSONString) throws JSONException, ParseException {
        ArrayList<StatusFactura> listaStatus = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(JSONString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonStatus = jsonArray.getJSONObject(i);
            String statusName = jsonStatus.getString("status");
            StatusFactura status = new StatusFactura(statusName);
            listaStatus.add(status);
        }
        return listaStatus;
    }

}
