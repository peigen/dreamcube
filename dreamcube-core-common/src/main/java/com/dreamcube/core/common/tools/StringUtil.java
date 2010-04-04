package com.dreamcube.core.common.tools;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Filename:StringUtil<br/>
 * 
 * Description:主要用于MD5算法的实现,使用java的MessageDigest<br/>
 * 
 * Version:V0.1<br/>
 * 
 * Author: peigen<br/>
 * 
 * History: <br/> [ Author Date Version Content ]<br/> peigen 2008-08-19 V0.1
 * create <br/>
 * 
 */
public class StringUtil {
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f"   };

    /**
     * 转换字节数组为16进制字串
     * 
     * @param b
     *            字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    /**
     * @description 字符串日期型转化为yyyy-MM-dd日期型
     * 
     * @param strDate
     *             
     * @return 转化后的日期型
     */
    public static Date stringToDate(String strDate) throws Exception {

        //日期格式化
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        //强制专为日期型
        Date cDate = df.parse(strDate);

        return cDate;

    }

    /**
     * @description 日期型转化为yyyy-MM-dd字符串
     * 
     * @param date
     *             
     * @return 转化后的字符串型
     */
    public static String dateToString(Date date) throws Exception {

        //日期格式化
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        //强制专为日期型  
        String strDate = df.format(date);

        return strDate;

    }

    public static void main(String[] args) {

        System.err.println(MD5Encode("peigen"));
        System.err.println("aebf1196ba695a49e5955c928a02628a".length());
    }

}
