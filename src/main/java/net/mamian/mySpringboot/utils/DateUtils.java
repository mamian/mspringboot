package net.mamian.mySpringboot.utils;

import org.apache.commons.lang3.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.joda.time.LocalDate;

/**
 * 日期计算（包括时区转换）
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2015-7-15 16:15:58
 * @copyright ©2015 马面 All Rights Reserved
 */
public class DateUtils {

    /**
     * rawOffset所在时区，今天0点所对应的服务器时间
     */
    public static Date getServerDateStartByClient(int rawOffset) {
        //此刻rawOffset所在时区的时间
        Date result = DateUtils.getDate(new Date().getTime(), rawOffset);
        return LocalDate.fromDateFields(result).toDate();
    }

    /**
     * rawOffset所在时区，今天0点在days天后所对应的服务器时间
     */
    public static Date getServerDateEndByClient(int rawOffset, int days) {
        //此刻rawOffset所在时区的时间
        Date result = DateUtils.getDate(new Date().getTime(), rawOffset);

        return LocalDate.fromDateFields(result).plusDays(days).toDate();
    }

    /**
     * 两段时间是否有交叉
     *
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    public static boolean isCrossHour(Date start1, Date end1, Date start2, Date end2) {
        if (LocalDate.fromDateFields(end1).isEqual(LocalDate.fromDateFields(start2))) {
            if (end1.getMinutes() == 0 && end1.getSeconds() == 0 && end1.getTime() % 1000 == 0) {//end1是整点
                if (start2.getHours() >= end1.getHours()) {
                    return false;
                }
            } else {//end1不是整点
                if (start2.getHours() >= end1.getHours() + 1) {
                    return false;
                }
            }
        }
        if (LocalDate.fromDateFields(start1).isEqual(LocalDate.fromDateFields(end2))) {
            if (end2.getMinutes() == 0 && end2.getSeconds() == 0 && end2.getTime() % 1000 == 0) {//end2是整点
                if (start1.getHours() >= end2.getHours()) {
                    return false;
                }
            } else {//end2不是整点
                if (start1.getHours() >= end2.getHours() + 1) {
                    return false;
                }
            }
        }
        return true;
    }

    //获取rawOffset1时区的hours1点，所对应的rawOffset2的整点
    public static int getHoursByRawOffset(int hours1, int rawOffset1, int rawOffset2) {
        int result = (rawOffset2 - rawOffset1) / (60 * 60 * 1000) + hours1;
        result = result < 0 ? result + 24 : result;
        result = result > 24 ? result - 24 : result;
        return result;
    }

    /**
     * 将time转换为timeZone时区下的Date
     *
     * @param time
     * @param rawoffset
     * @return
     */
    public static Date getDate(long time, int rawoffset) {
        return new Date(time - TimeZone.getDefault().getRawOffset() + rawoffset);
    }

    /**
     * 求rawoffset时区的date所对应的时间戳(不考虑夏令时)
     *
     * @param date
     * @param rawoffset
     * @return
     */
    public static long getTime(Date date, int rawoffset) {
        return date.getTime() + (rawoffset - TimeZone.getDefault().getRawOffset());
    }

    /**
     * 根据rawoffset获取时区
     *
     * @param rawoffset
     * @return
     */
    private static TimeZone getTimeZone(int rawoffset) {
        String[] timeZoneIds = TimeZone.getAvailableIDs(rawoffset);
        if (timeZoneIds.length == 0) {
            return TimeZone.getDefault();
        }
        TimeZone result = TimeZone.getTimeZone(timeZoneIds[0]);
        return null == result ? TimeZone.getDefault() : result;
    }

    /**
     *
     * @param dateStr
     * @param dateFormat
     * @return
     */
    public static Date str2Date(final String dateStr, final String dateFormat) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            return sdf.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String date2Str(final Date date, final String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

}
