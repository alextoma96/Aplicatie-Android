package Networking;

import android.icu.text.DateTimePatternGenerator;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Commons.Angajat;
import Commons.Client;
import Commons.CotaTVA;
import Commons.Factura;
import Commons.IdentitateCompanie;
import Commons.Moneda;
import Commons.SerieFactura;
import Commons.StatusFactura;
import Utils.Constant;

/**
 * Created by idanciu on 9/12/2017.
 */

public class HttpConnection extends AsyncTask <String, Void, ArrayList<Factura>> implements Constant{
    URL url;
    HttpURLConnection connection;
    SimpleDateFormat dateFormat = SIMPLE_DATE_FORMAT;

    @Override
    protected ArrayList<Factura> doInBackground(String... params) {
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
        }

        return null;
    }

    private ArrayList<Factura> parseHttpResponse(String JSONString) throws JSONException {
        ArrayList<Factura> listaFacturi = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(JSONString);
        for (int i = 0; i < jsonArray.length(); i++) {
   //         try {
                JSONObject jsonFactura = jsonArray.getJSONObject(i);
                Double total = jsonFactura.getDouble("total");
                Double tva = jsonFactura.getDouble("tva");
                JSONObject jsonSerieFactura = jsonFactura.getJSONObject("serieFactura");
                SerieFactura serieFactura = parseSerieFactura(jsonSerieFactura);
                String numar = jsonFactura.getString("numar");
                String dtScadentaString = jsonFactura.getString("dtScadenta");
                Date dtScadenta = new Date();
//                if(dtScadentaString != null) {
//                    dtScadenta = dateFormat.parse(dtScadentaString);
//                }
                JSONObject jsonStatusFactura = jsonFactura.getJSONObject("statusFactura");
                StatusFactura statusFactura = parseStatusFactura(jsonStatusFactura);
                String dtEmitereString = jsonFactura.getString("dtEmitere");
                Date dtEmitere = new Date();
//                if(dtEmitereString != null) {
//                    dtEmitere = dateFormat.parse(dtEmitereString);
//                }
//                JSONObject jsonValidatDe = jsonFactura.getJSONObject("validatDe");
//                JSONObject jsonEmisDe = jsonFactura.getJSONObject("emisDe");
               // Angajat emisDe = parseAngajat(jsonEmisDe);
                String observatii = jsonFactura.getString("observatii");
//                JSONObject jsonAngajat = jsonFactura.getJSONObject("angajat");
  //              Angajat responsabil = parseAngajat(jsonAngajat);
                String dtEstimataString = jsonFactura.getString("dtEstimata");
                Date dtEstimata = new Date();
//                if(dtEmitereString != null) {
//                    dtEstimata = dateFormat.parse(dtEstimataString);
//                }
                JSONObject jsonClient = jsonFactura.getJSONObject("client");
                Client client = parseClient(jsonClient);
                Double suma = jsonFactura.getDouble("suma");
                JSONObject jsonMoneda = jsonFactura.getJSONObject("moneda");
                Moneda moneda = parseMoneda(jsonMoneda);
                JSONObject jsonCotaTVA = jsonFactura.getJSONObject("cotaTVA");
                CotaTVA cotaTVA = parseCotaTVA(jsonCotaTVA);
                JSONObject jsonIdentitateCompanie = jsonFactura.getJSONObject("identitateCompanie");
                IdentitateCompanie identitateCompanie = parseIdentitateCompanie(jsonIdentitateCompanie);
              //  JSONObject jsonCreatDe = jsonFactura.getJSONObject("creatDe");
               // Angajat creatDe = parseAngajat(jsonCreatDe);
                String memo = jsonFactura.getString("memo");
                Integer id = jsonFactura.getInt("id");

//                Factura factura = new Factura(serieFactura, numar, dtEstimata, dtEmitere, dtScadenta, suma, tva, total,
//                        memo, responsabil, creatDe, validatDe, emisDe, moneda, statusFactura, client,
//                        identitateCompanie, cotaTVA, observatii);
            Factura factura = new Factura(serieFactura, numar, dtEstimata, dtEmitere, dtScadenta, suma, tva, total,
                    memo, null, null, null, null, moneda, statusFactura, client,
                    identitateCompanie, cotaTVA, observatii);
                listaFacturi.add(factura);
                for (Factura f : listaFacturi) {
                    Log.i("factura", f.toString());
                }

//            } catch (ParseException e) {
//                    e.printStackTrace();
//            }
        }
        return listaFacturi;
}

    private SerieFactura parseSerieFactura(JSONObject object) throws JSONException {
        Integer secventa = object.getInt("secventa");
        String cod = object.getString("cod");
        return new SerieFactura(secventa, cod);
    }

    private StatusFactura parseStatusFactura(JSONObject object) throws JSONException {
        Integer id = object.getInt("id");
        String status = object.getString("status");
        return new StatusFactura(id, status);
    }

    private Angajat parseAngajat(JSONObject object) throws JSONException {
        String email = object.getString("email");
        String cod = object.getString("cod");
        String telefon = object.getString("telefon");
        String nume = object.getString("nume");
        String memo = object.getString("memo");
        return new Angajat(cod, nume, memo, email, telefon);
    }

    private Client parseClient(JSONObject object) throws JSONException {
        String codFiscal = object.getString("codFiscal");
        String banca = object.getString("banca");
        String iban = object.getString("iban");
        String adresa = object.getString("adresa");
        String email = object.getString("email");
        String cod = object.getString("cod");
        String termenPlata = object.getString("termenPlata");
        String telefon = object.getString("telefon");
        String codInregistrare = object.getString("codInregistrare");
        String nume = object.getString("nume");
        String persoanaContact = object.getString("persoanaContact");
        String memo = object.getString("memo");
        return new Client(nume, cod, adresa, codInregistrare, codFiscal, banca, iban, memo, persoanaContact, telefon, email, termenPlata, null);
    }

    private Moneda parseMoneda(JSONObject object) throws JSONException {
//        Boolean implicita = object.getBoolean("implicita");
  //      Boolean referinta = object.getBoolean("referinta");
        String cod = object.getString("cod");
        String nume = object.getString("nume");
//        return new Moneda(cod, nume, implicita, referinta);
        return new Moneda(cod, nume, null, null);
// da
    }

    private CotaTVA parseCotaTVA(JSONObject object) throws JSONException {
        String cod = object.getString("cod");
        Double procent = object.getDouble("procent");
        String nume = object.getString("nume");
        String memo = object.getString("memo");
        return new CotaTVA(cod, nume, procent, memo);
    }

    private IdentitateCompanie parseIdentitateCompanie(JSONObject object) throws JSONException {
        Integer id = object.getInt("id");
        String codFiscal = object.getString("codFiscal");
        String banca = object.getString("banca");
        String iban = object.getString("iban");
        String adresa = object.getString("adresa");
        String codInregistrare = object.getString("codInregistrare");
        String nume = object.getString("nume");
        String memo = object.getString("memo");
        return new IdentitateCompanie(id, nume, adresa, codInregistrare, codFiscal, banca, iban, memo);
    }

}