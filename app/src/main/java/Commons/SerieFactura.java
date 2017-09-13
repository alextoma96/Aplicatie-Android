package Commons;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by idanciu on 9/12/2017.
 */

public class SerieFactura implements Parcelable{
    private Integer secventa;
    private String cod;

    public SerieFactura(Integer secventa, String cod) {
        this.secventa = secventa;
        this.cod = cod;
    }

    protected SerieFactura(Parcel in) {
        secventa = in.readInt();
        cod = in.readString();
    }

    public static final Creator<SerieFactura> CREATOR = new Creator<SerieFactura>() {
        @Override
        public SerieFactura createFromParcel(Parcel in) { return new SerieFactura(in); }

        @Override
        public SerieFactura[] newArray(int size) { return new SerieFactura[size]; }
    };

    public Integer getSecventa() { return secventa; }
    public SerieFactura setSecventa(Integer secventa) { this.secventa = secventa; return this;}

    public String getCod() { return cod; }
    public void setCod(String cod) { this.cod = cod; }

    @Override
    public String toString() {
        return "SerieFactura{" +
                "secventa=" + secventa +
                "cod=" + cod +
                '}';
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(secventa);
        dest.writeString(cod);
    }
}
