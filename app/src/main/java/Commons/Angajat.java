package Commons;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by idanciu on 9/12/2017.
 */

public class Angajat implements Parcelable{
    private String cod;
    private String nume;
    private String memo;
    private String email;
    private String telefon;

    public Angajat(Parcel in) {
        cod = in.readString();
        nume = in.readString();
        memo = in.readString();
        email = in.readString();
        telefon = in.readString();
    }

    public Angajat(String cod, String nume, String memo, String email, String telefon) {
        this.cod = cod;
        this.nume = nume;
        this.memo = memo;
        this.email = email;
        this.telefon = telefon;
    }

    public String getCod() { return cod; }
    public Angajat setCod(String cod) { this.cod = cod; return this;}

    public String getNume() { return nume; }
    public Angajat setNume(String nume) { this.nume = nume; return this;}

    public String getMemo() { return memo; }
    public Angajat setMemo(String memo) { this.memo = memo; return this;}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefon() {	return telefon;	}
    public void setTelefon(String telefon) {this.telefon = telefon;	}

    @Override
    public String toString() {
        return "Angajat{" +
                "cod='" + cod + '\'' +
                ", nume='" + nume + '\'' +
                ", memo='" + memo + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }

    public static final Parcelable.Creator<Angajat> CREATOR = new Creator<Angajat>() {
        @Override
        public Angajat createFromParcel(Parcel source) { return new Angajat(source); }

        @Override
        public Angajat[] newArray(int size) { return new Angajat[size]; }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cod);
        dest.writeString(nume);
        dest.writeString(memo);
        dest.writeString(email);
        dest.writeString(telefon);
    }
}
