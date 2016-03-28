package utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mate on 2016.03.28..
 * DateUtils
 */
public class DateUtils {

    public static Date getEarlierDateByMinutes(int beforeMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, -beforeMinutes);
        return cal.getTime();
    }
}
