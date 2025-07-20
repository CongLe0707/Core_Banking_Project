package vn.hdbank.delegation.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@UtilityClass
@Slf4j
public class DateTimeUtils {
    public static final String YYYY_MM_DD_T_HH_MM_SS_SSS = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String DD_MM_YYYY_T_HH_MM_SS_SSS = "dd-MM-yyyy'T'HH:mm:ss.SSS";
    public static final String DDMMYYYYHHMMSS = "ddMMyyyyHHmmss";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String VN_TIME_ZONE = "Asia/Ho_Chi_Minh";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";

    public static String formatDate(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(VN_TIME_ZONE));
        return simpleDateFormat.format(date);
    }

    public static Date parseDate(String dateStr, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(VN_TIME_ZONE));
            return simpleDateFormat.parse(dateStr);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String currentDate(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(VN_TIME_ZONE));
        return simpleDateFormat.format(new Date());
    }

    public static boolean checkTwoFormatDate(String splatDate, String dashDate) {
        String methodName = "checkTwoFormatDate";
        log.info("DateTimeUtils - {} ,splatDate: {}, dashDate: {} ", methodName, splatDate, dashDate);
        if (StringUtils.isEmpty(dashDate)) {
            return false;
        }
        // Define the date formats
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            // Parse the dates
            LocalDate date1 = LocalDate.parse(splatDate, formatter1);
            LocalDate date2 = LocalDate.parse(dashDate, formatter2);

            // Compare the dates
            return date1.equals(date2);
        } catch (Exception exception) {
            log.error("DateTimeUtils - checkTwoFormatDate err: ", exception);
            return false;
        }
    }
}
