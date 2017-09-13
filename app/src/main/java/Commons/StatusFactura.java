package Commons;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by idanciu on 9/12/2017.
 */

public class StatusFactura implements Parcelable{
    private Integer id;
    private String status;

    public StatusFactura(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    protected StatusFactura(Parcel in) {
        id = in.readInt();
        status = in.readString();
    }

    public static final Creator<StatusFactura> CREATOR = new Creator<StatusFactura>() {
        @Override
        public StatusFactura createFromParcel(Parcel in) { return new StatusFactura(in); }

        @Override
        public StatusFactura[] newArray(int size) { return new StatusFactura[size]; }
    };

    public Integer getId() { return id; }
    public StatusFactura setId(Integer id) { this.id = id; return this;}

    public String getStatus() { return status; }
    public StatusFactura setStatus(String status) { this.status = status; return this;}

    @Override
    public String toString() {
        return "StatusFactura{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(status);
    }
}
