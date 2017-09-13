package Commons;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by idanciu on 9/12/2017.
 */

public class Client implements Parcelable{

    private String nume;
    private String cod;
    private String adresa;
    private String codInregistrare;
    private String codFiscal;
    private String banca;
    private String iban;
    private String memo;
    private String persoanaContact;
    private String telefon;
    private String email;
    private String termenPlata;
    private List<Factura> facturi;

    public Client(String nume, String cod, String adresa, String codInregistrare, String codFiscal, String banca, String iban, String memo, String persoanaContact, String telefon, String email, String termenPlata, List<Factura> facturi) {
        this.nume = nume;
        this.cod = cod;
        this.adresa = adresa;
        this.codInregistrare = codInregistrare;
        this.codFiscal = codFiscal;
        this.banca = banca;
        this.iban = iban;
        this.memo = memo;
        this.persoanaContact = persoanaContact;
        this.telefon = telefon;
        this.email = email;
        this.termenPlata = termenPlata;
        this.facturi = facturi;
    }

    protected Client(Parcel in) {
        nume = in.readString();
        cod = in.readString();
        adresa = in.readString();
        codInregistrare = in.readString();
        codFiscal = in.readString();
        banca = in.readString();
        iban = in.readString();
        memo = in.readString();
        persoanaContact = in.readString();
        telefon = in.readString();
        email = in.readString();
        termenPlata = in.readString();
    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) { return new Client(in); }

        @Override
        public Client[] newArray(int size) { return new Client[size]; }
    };

    public String getCod() { return cod; }
    public Client setCod(String cod) { this.cod = cod; return this;}

    public String getNume() { return nume; }
    public Client setNume(String nume) { this.nume = nume; return this;}

    public String getCodInregistrare() { return codInregistrare; }
    public Client setCodInregistrare(String codInregistrare) { this.codInregistrare = codInregistrare; return this;}

    public String getCodFiscal() { return codFiscal; }
    public Client setCodFiscal(String codFiscal) { this.codFiscal = codFiscal; return this;}

    public String getAdresa() { return adresa; }
    public Client setAdresa(String adresa) { this.adresa = adresa; return this;}

    public String getBanca() { return banca; }
    public Client setBanca(String banca) { this.banca = banca; return this;}

    public String getIban() { return iban; }
    public Client setIban(String iban) { this.iban = iban; return this;}

    public String getMemo() { return memo; }
    public Client setMemo(String memo) { this.memo = memo; return this;}

    public List<Factura> getFacturi() { return facturi; }
    public Client setFacturi(List<Factura> facturi) { this.facturi = facturi; return this; }

//    public Boolean getExtern() { return extern; }
//    public Client setExtern(Boolean extern) { this.extern = extern; return this; }
//
//    public Boolean getAcelasiGrup() { return acelasiGrup; }
//    public Client setAcelasiGrup(Boolean acelasiGrup) { this.acelasiGrup = acelasiGrup; return this; }

    public String getPersoanaContact() { return persoanaContact; }
    public Client setPersoanaContact(String persoanaContact) { this.persoanaContact = persoanaContact; return this; }

    public String getTelefon() { return telefon; }
    public Client setTelefon(String telefon) { this.telefon = telefon; return this; }

    public String getEmail() { return email; }
    public Client setEmail(String email) { this.email = email; return this; }

    public String getTermenPlata() { return termenPlata; }
    public Client setTermenPlata(String termenPlata) { this.termenPlata = termenPlata; return this; }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", cod='" + cod + '\'' +
                ", adresa='" + adresa + '\'' +
                ", codInregistrare='" + codInregistrare + '\'' +
                ", codFiscal='" + codFiscal + '\'' +
                ", banca='" + banca + '\'' +
                ", iban='" + iban + '\'' +
                ", memo='" + memo + '\'' +
//                ", extern=" + extern +
//                ", acelasiGrup=" + acelasiGrup +
                ", persoanaContact='" + persoanaContact + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", termenPlata='" + termenPlata + '\'' +
                ", facturi=" + facturi +
                '}';
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(cod);
        dest.writeString(adresa);
        dest.writeString(codInregistrare);
        dest.writeString(codFiscal);
        dest.writeString(banca);
        dest.writeString(iban);
        dest.writeString(memo);
        dest.writeString(persoanaContact);
        dest.writeString(telefon);
        dest.writeString(email);
        dest.writeString(termenPlata);
        dest.writeList(facturi);
    }
}
