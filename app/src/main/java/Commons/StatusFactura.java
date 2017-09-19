package Commons;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by idanciu on 9/12/2017.
 */

public class StatusFactura implements Parcelable{
    private String status;
    private Integer nrFacturi;

    public StatusFactura(String status) {
        this.status = status;
    }


    public StatusFactura(String status, Integer nrFacturi) {
        this.status = status;
        this.nrFacturi = nrFacturi;
    }

    public StatusFactura(Integer id, String status) {
        this.status = status;
    }

    public StatusFactura(Parcel in) {
        status = in.readString();
    }

    public static final Creator<StatusFactura> CREATOR = new Creator<StatusFactura>() {
        @Override
        public StatusFactura createFromParcel(Parcel in) { return new StatusFactura(in); }

        @Override
        public StatusFactura[] newArray(int size) { return new StatusFactura[size]; }
    };

    public String getStatus() { return status; }
    public StatusFactura setStatus(String status) { this.status = status; return this;}

    @Override
    public String toString() {
        return status +  "(" + nrFacturi + " facturi)";
    }



    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
    }
}
