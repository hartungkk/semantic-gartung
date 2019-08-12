package DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getCurrentDateAndTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy - HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }
}
