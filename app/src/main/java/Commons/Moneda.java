package Commons;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by idanciu on 9/12/2017.
 */

public class Moneda implements Parcelable{

    private String cod;
    private String nume;
    private Boolean implicita;
    private Boolean referinta;

    public Moneda(String cod, String nume, Boolean implicita, Boolean referinta) {
        this.cod = cod;
        this.nume = nume;
        this.implicita = implicita;
        this.referinta = referinta;
    }

    protected Moneda(Parcel in) {
        cod = in.readString();
        nume = in.readString();
    }

    public static final Creator<Moneda> CREATOR = new Creator<Moneda>() {
        @Override
        public Moneda createFromParcel(Parcel in) { return new Moneda(in); }

        @Override
        public Moneda[] newArray(int size) { return new Moneda[size]; }
    };

    public String getCod() { return cod; }
    public Moneda setCod(String cod) { this.cod = cod; return this; }

    public Boolean getImplicita() {	return implicita; }
    public Moneda setImplicita(Boolean implicita) { this.implicita = implicita; return this; }

    public Boolean getReferinta() {	return referinta; }
    public Moneda setReferinta(Boolean referinta) { this.referinta = referinta; return this; }

    public String getNume() { return nume; }
    public Moneda setNume(String nume) { this.nume = nume; return this; }

    @Override
    public String toString() {
        return "Moneda{" +
                "cod='" + cod + '\'' +
                ", nume='" + nume + '\'' +
                ", implicita=" + implicita +
                ", referinta=" + referinta +
                '}';
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cod);
        dest.writeString(nume);
    }
}
