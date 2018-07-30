package com.dheeraj.utility.helper;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Dheeraj Reddy
 * Date: 30/07/18
 */

public class DateHelper {
    public static final String DATE_TIME_ZONE = "Asia/Kolkata";
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String getUTCDateTime() {
        String today = new DateTime(DateTimeZone.UTC).toString(DateTimeFormat.forPattern(DATE_TIME_PATTERN));
        return today;
    }

    public static String getIndianDateTime() {
        String today = new DateTime(DateTimeZone.forID(DATE_TIME_ZONE)).toString(DateTimeFormat.forPattern(DATE_TIME_PATTERN));
        return today;
    }
}