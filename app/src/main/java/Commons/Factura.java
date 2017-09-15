package Commons;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by idanciu on 9/12/2017.
 */

public class Factura implements Parcelable{

    private SerieFactura serieFactura;
    private String numar;
    private Date dtEstimata;
    private Date dtEmitere;
    private Date dtScadenta;
    private double suma;
    private double tva;
    private double total;
    private String memo;
    private Angajat angajat;
    private Angajat creatDe;
    private Angajat validatDe;
    private Angajat emisDe;
    private Moneda moneda;
    private StatusFactura statusFactura;
    private Client client;
    private IdentitateCompanie identitateCompanie;
    private CotaTVA cotaTVA;
    private String observatii;

    public Factura() { }

    public Factura(SerieFactura serieFactura, String numar, Date dtEstimata, Date dtEmitere, Date dtScadenta, double suma, double tva, double total, String memo, Angajat angajat, Angajat creatDe, Angajat validatDe, Angajat emisDe, Moneda moneda, StatusFactura statusFactura, Client client, IdentitateCompanie identitateCompanie, CotaTVA cotaTVA, String observatii) {
        this.serieFactura = serieFactura;
        this.numar = numar;
        this.dtEstimata = dtEstimata;
        this.dtEmitere = dtEmitere;
        this.dtScadenta = dtScadenta;
        this.suma = suma;
        this.tva = tva;
        this.total = total;
        this.memo = memo;
        this.angajat = angajat;
        this.creatDe = creatDe;
        this.validatDe = validatDe;
        this.emisDe = emisDe;
        this.moneda = moneda;
        this.statusFactura = statusFactura;
        this.client = client;
        this.identitateCompanie = identitateCompanie;
        this.cotaTVA = cotaTVA;
        this.observatii = observatii;
    }

    protected Factura(Parcel in) {
        numar = in.readString();
        suma = in.readDouble();
        tva = in.readDouble();
        total = in.readDouble();
        memo = in.readString();
        angajat = in.readParcelable(Angajat.class.getClassLoader());
        creatDe = in.readParcelable(Angajat.class.getClassLoader());
        validatDe = in.readParcelable(Angajat.class.getClassLoader());
        emisDe = in.readParcelable(Angajat.class.getClassLoader());
        client = in.readParcelable(Client.class.getClassLoader());
        cotaTVA = in.readParcelable(CotaTVA.class.getClassLoader());
        observatii = in.readString();
    }

    public static final Creator<Factura> CREATOR = new Creator<Factura>() {
        @Override
        public Factura createFromParcel(Parcel in) { return new Factura(in); }

        @Override
        public Factura[] newArray(int size) { return new Factura[size]; }
    };

    public SerieFactura getSerieFactura() { return serieFactura; }
    public Factura setSerieFactura(SerieFactura serieFactura) { this.serieFactura = serieFactura; return this; }

    public String getNumar() { return numar; }
    public Factura setNumar(String numar) { this.numar = numar; return this; }

    public Date getDtEmitere() { return dtEmitere; }
    public Factura setDtEmitere(Date dtEmitere) { this.dtEmitere = dtEmitere; return this; }

    public Date getDtScadenta() { return dtScadenta; }
    public Factura setDtScadenta(Date dtScadenta) { this.dtScadenta = dtScadenta; return this; }

    public double getSuma() { return suma; }
    public Factura setSuma(double suma) { this.suma = suma; return this; }

    public double getTva() { return tva; }
    public Factura setTva(double tva) { this.tva = tva; return this; }

    public double getTotal() { return total; }
    public Factura setTotal(double total) { this.total = total; return this; }

    public String getMemo() { return memo; }
    public Factura setMemo(String memo) { this.memo = memo; return this; }

    public Angajat getAngajat() { return angajat; }
    public Factura setAngajat(Angajat angajat) { this.angajat = angajat; return this; }

    public Moneda getMoneda() { return moneda; }
    public Factura setMoneda(Moneda moneda) { this.moneda = moneda; return this; }

    public StatusFactura getStatusFactura() { return statusFactura; }
    public Factura setStatusFactura(StatusFactura statusFactura) { this.statusFactura = statusFactura; return this; }

    public Client getClient() { return client; }
    public Factura setClient(Client client) { this.client = client; return this; }

    public String getSerieNumar() { return serieFactura + " " + numar; }

    public IdentitateCompanie getIdentitateCompanie() { return identitateCompanie; }
    public Factura setIdentitateCompanie(IdentitateCompanie identitateCompanie) { this.identitateCompanie = identitateCompanie; return this; }

    public CotaTVA getCotaTVA() { return cotaTVA; }
    public Factura setCotaTVA(CotaTVA cotaTVA) { this.cotaTVA = cotaTVA; return this; }

    public Angajat getCreatDe() { return creatDe; }
    public Factura setCreatDe(Angajat creatDe) { this.creatDe = creatDe; return this;}

    public Angajat getValidatDe() { return validatDe; }
    public Factura setValidatDe(Angajat validatDe) { this.validatDe = validatDe; return this;}

    public Angajat getEmisDe() { return emisDe; }
    public Factura setEmisDe(Angajat emisDe) { this.emisDe = emisDe; return this;}

    public Date getDtEstimata() { return dtEstimata; }
    public Factura setDtEstimata(Date dtEstimata) { this.dtEstimata = dtEstimata; return this; }

    public String getObservatii() { return observatii; }
    public Factura setObservatii(String observatii) { this.observatii = observatii; return this; }

    @Override
    public String toString() {
        return  "Client: " + client.getNume()+
                ", dată emitere: '" + dtEmitere +
                ", serie/nr.: " + serieFactura.getCod() + " " + numar +
                ", total: " + total +
                ", moneda: " + moneda.getCod() +
//                ", responsabil: " + angajat.getNume() +
                ", status: " + statusFactura.getStatus();
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numar);
        dest.writeDouble(suma);
        dest.writeDouble(tva);
        dest.writeDouble(total);
        dest.writeString(memo);
        dest.writeParcelable(angajat, flags);
        dest.writeParcelable(creatDe, flags);
        dest.writeParcelable(validatDe, flags);
        dest.writeParcelable(emisDe, flags);
        dest.writeParcelable(client, flags);
        dest.writeParcelable(cotaTVA, flags);
        dest.writeString(observatii);
    }
}
