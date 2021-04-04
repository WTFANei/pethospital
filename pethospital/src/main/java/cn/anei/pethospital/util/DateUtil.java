package cn.anei.pethospital.util;


import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {

    private static  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date String2Date(String dateStr) throws Exception {
        Date date = sdf.parse(dateStr);
        return date;
    }

}
