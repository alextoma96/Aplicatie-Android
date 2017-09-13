package Commons;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by idanciu on 9/12/2017.
 */

public class IdentitateCompanie implements Parcelable{
    private Integer id;
    private String nume;
    private String adresa;
    private String codInregistrare;
    private String codFiscal;
    private String banca;
    private String iban;
    private String memo;

    public IdentitateCompanie(Integer id, String nume, String adresa, String codInregistrare, String codFiscal, String banca, String iban, String memo) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.codInregistrare = codInregistrare;
        this.codFiscal = codFiscal;
        this.banca = banca;
        this.iban = iban;
        this.memo = memo;
    }

    protected IdentitateCompanie(Parcel in) {
        id = in.readInt();
        nume = in.readString();
        adresa = in.readString();
        codInregistrare = in.readString();
        codFiscal = in.readString();
        banca = in.readString();
        iban = in.readString();
        memo = in.readString();
    }

    public static final Creator<IdentitateCompanie> CREATOR = new Creator<IdentitateCompanie>() {
        @Override
        public IdentitateCompanie createFromParcel(Parcel in) { return new IdentitateCompanie(in); }

        @Override
        public IdentitateCompanie[] newArray(int size) { return new IdentitateCompanie[size]; }
    };

    public Integer getId() { return id;	}
    public IdentitateCompanie setId(Integer id) {	this.id = id; return this; }

    public String getNume() { return nume; }
    public IdentitateCompanie setNume(String nume) { this.nume = nume; return this;}

    public String getCodInregistrare() { return codInregistrare; }
    public IdentitateCompanie setCodInregistrare(String codInregistrare) { this.codInregistrare = codInregistrare; return this;}

    public String getCodFiscal() { return codFiscal; }
    public IdentitateCompanie setCodFiscal(String codFiscal) { this.codFiscal = codFiscal; return this;}

    public String getAdresa() { return adresa; }
    public IdentitateCompanie setAdresa(String adresa) { this.adresa = adresa; return this;}

    public String getBanca() { return banca; }
    public IdentitateCompanie setBanca(String banca) { this.banca = banca; return this;}

    public String getIban() { return iban; }
    public IdentitateCompanie setIban(String iban) { this.iban = iban; return this;}

    public String getMemo() { return memo; }
    public IdentitateCompanie setMemo(String memo) { this.memo = memo; return this;}

    @Override
    public String toString() {
        return "IdentitateCompanie{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", codInregistrare='" + codInregistrare + '\'' +
                ", codFiscal='" + codFiscal + '\'' +
                ", banca='" + banca + '\'' +
                ", iban='" + iban + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nume);
        dest.writeString(adresa);
        dest.writeString(codInregistrare);
        dest.writeString(codFiscal);
        dest.writeString(banca);
        dest.writeString(iban);
        dest.writeString(memo);
    }
}
