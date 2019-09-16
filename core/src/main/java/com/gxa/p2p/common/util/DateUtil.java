package com.gxa.p2p.common.util;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 得到一天的最后一秒钟
     *
     * @param date
     * @return
     */
    public static Date endOfDay(Date date) {
        return DateUtils.addSeconds(
                DateUtils.addDays(
                        DateUtils.truncate(date, Calendar.DATE), 1), -1);
    }

    /**
     * 用来计算发送两次验证码之间的间隔
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long getBetweenSecond(Date d1, Date d2) {
        return Math.abs((d1.getTime() - d2.getTime()) / 1000);
    }



    //计算招标到期时间
    public static Date getBidrequestMaturity(Date auditTime,int disableDays){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(auditTime);
        rightNow.add(Calendar.DAY_OF_MONTH,disableDays);//加上招标天数
        Date dt1=rightNow.getTime();
        return dt1;
    }
}