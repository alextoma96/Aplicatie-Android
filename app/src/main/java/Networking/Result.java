package Networking;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import Commons.Factura;

/**
 * Created by idanciu on 9/12/2017.
 */

public class Result implements Parcelable{
    private ArrayList<Factura> listaFacturi;

    public Result(ArrayList<Factura> listaFacturi) { this.listaFacturi = listaFacturi; }

    protected Result(Parcel in) { listaFacturi = in.createTypedArrayList(Factura.CREATOR); }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) { return new Result(in); }

        @Override
        public Result[] newArray(int size) { return new Result[size]; }
    };

    public ArrayList<Factura> getListaFacturi() { return listaFacturi; }

    public void setListaFacturi(ArrayList<Factura> listaFacturi) { this.listaFacturi = listaFacturi; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) { dest.writeTypedList(listaFacturi); }

    @Override
    public String toString() {
        return "Result{" +
                "listaFacturi=" + listaFacturi +
                '}';
    }
}

