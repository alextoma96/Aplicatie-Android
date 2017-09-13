package Utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by idanciu on 9/12/2017.
 */

public interface Constant {
    public static String DATE_FORMAT = "dd.mm.yyyy";
    public static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
    public String FACTURA_KEY = "factura";
}
