package Commons;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by idanciu on 9/12/2017.
 */

public class Utilizator implements Parcelable{
    private String nume;
    private String username;
    private String parola;
    private Angajat angajat;

    public Utilizator(String nume, String username, String parola, Angajat angajat) {
        this.nume = nume;
        this.username = username;
        this.parola = parola;
        this.angajat = angajat;
    }

    protected Utilizator(Parcel in) {
        nume = in.readString();
        username = in.readString();
        parola = in.readString();
        angajat = in.readParcelable(Angajat.class.getClassLoader());
    }

    public static final Creator<Utilizator> CREATOR = new Creator<Utilizator>() {
        @Override
        public Utilizator createFromParcel(Parcel in) { return new Utilizator(in); }

        @Override
        public Utilizator[] newArray(int size) { return new Utilizator[size]; }
    };

    public String getNume() { return nume; }
    public Utilizator setNume(String nume) { this.nume = nume; return this;}

    public String getUsername() { return username; }
    public Utilizator setUsername(String username) { this.username = username; return this;}

    public String getParola() { return parola; }
    public Utilizator setParola(String parola) { this.parola = parola; return this; }

    public Angajat getAngajat() { return angajat; }
    public Utilizator setAngajat(Angajat angajat) { this.angajat = angajat; return this;}

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(username);
        dest.writeString(parola);
        dest.writeParcelable(angajat, flags);
    }

    @Override
    public String toString() {
        return  "Nume: " + nume +
                ", username: " + username +
                ", parola: " + parola +
                ", angajat: " + angajat.getNume();
    }
}
