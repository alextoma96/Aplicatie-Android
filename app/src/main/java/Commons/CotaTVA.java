package Commons;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by idanciu on 9/12/2017.
 */

public class CotaTVA implements Parcelable{
    private String cod;
    private String nume;
    private double procent;
    private String memo;

    public CotaTVA(String cod, String nume, double procent, String memo) {
        this.cod = cod;
        this.nume = nume;
        this.procent = procent;
        this.memo = memo;
    }

    protected CotaTVA(Parcel in) {
        cod = in.readString();
        nume = in.readString();
        procent = in.readDouble();
        memo = in.readString();
    }

    public static final Creator<CotaTVA> CREATOR = new Creator<CotaTVA>() {
        @Override
        public CotaTVA createFromParcel(Parcel in) { return new CotaTVA(in); }

        @Override
        public CotaTVA[] newArray(int size) { return new CotaTVA[size]; }
    };

    public String getCod() { return cod; }
    public CotaTVA setCod(String cod) { this.cod = cod; return this; }

    public String getNume() { return nume; }
    public CotaTVA setNume(String nume) { this.nume = nume; return this; }

    public double getProcent() { return procent; }
    public CotaTVA setProcent(double procent) { this.procent = procent; return this; }

    public String getMemo() { return memo; }
    public CotaTVA setMemo(String memo) { this.memo = memo; return this; }

    @Override
    public String toString() {
        return "CotaTVA{" +
                "cod='" + cod + '\'' +
                ", nume='" + nume + '\'' +
                ", procent=" + procent +
                ", memo='" + memo + '\'' +
                '}';
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cod);
        dest.writeString(nume);
        dest.writeDouble(procent);
        dest.writeString(memo);
    }
}
