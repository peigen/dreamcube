package com.dreamcube.core.common.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dreamcube.core.common.util.Money;

/**
 *                       
 *Filename: ValidateUtil.java
 *
 *Description: 
 *
 *Version: 0.1
 *
 *Author: peigen
 *
 *Email: peigen123@gmail.com
 *
 *Blog: http://peigen.info
 *
 *       
 *History:<br>
 *<li>Author: peigen</li>
 *<li>Date: 2010-4-5</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class ValidateTool {
    //手机格式的正则表达式
    public final static String REGEX_MOBILE            = "^[1](3|5|8)[0-9]{9}$";

    //Email格式的正则表达式
    public final static String REGEX_EMAIL             = "^([a-zA-Z0-9_\\.\\-\\+])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";

    //支付宝登录号的正则表达式
    public final static String REGEX_LOGON_ID          = "^(([a-zA-Z0-9_\\.\\-\\+])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+)|([1](3|5|8)[0-9]{9})$";

    //手机6位数字校验码
    public final static String REGUX_VALIDATE_CODE     = "^\\d{6}$";

    //16位纯数字流水号
    public final static String REGEX_VALIDATE_BIZ_NO   = "^\\d{16}$";

    //4位图片校验码
    public final static String REGEX_PIC_CODE          = "^\\d{4}$";

    //电话号码，只能由数字和"-"组成,6到20位。
    public final static String REGEX_PHONE             = "^[0-9,-]{6,20}$";

    //邮政编码,只能6位数字
    public final static String POST                    = "^\\d{1,6}$";

    //用户姓名,只能由中文汉字、大写英文字母或.构成
    public final static String REGEX_USER_NAME         = "^([\u4e00-\u9fa5|A-Z]+\\s*\\.?\\s*)+[\u4e00-\u9fa5|A-Z]$";

    //纯数字
    public final static String NUM                     = "^(\\d)+$";

    //金额，类似于-135,342,12.954
    public final static String REGEX_VALIDATE_MONEY    = "^[+-]?\\d+(,\\d{3})*(\\.\\d+)?$";

    //手机动态口令，可以不输入，输入长度只能数字长度6位
    public final static String MOBILE_PROTECT_ACK_CODE = "^\\d{0}|\\d{6}$";

    /**
     * 判断输入的字符串是否和传入的正则是否匹配
     * 
     * @param src 待判断的输入字符串
     * @param reg 正则表达式
     * @return True:输入的字符串是否和传入的正则匹配
     *         False:输入的字符串是否和传入的正则不匹配
     */
    public static boolean isValidReg(String src, String reg) {
        // 无效的输入，直接返回false
        if (StringTool.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(reg);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 判断输入的字符串是否是合法用户姓名,长度未限制
     * 
     * @param src 待判断的输入字符串
     * @return True:是合法的用户姓名;False:不是合法的用户姓名
     */
    public static boolean isValidUserName(String src) {
        // 无效的输入，直接返回false
        if (StringTool.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_USER_NAME);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 判断输入的字符串是否是合法email格式,长度未限制
     * 
     * @param src 待判断的输入字符串
     * @return True:是合法的email;False:不是合法的email
     */
    public static boolean isValidEmail(String src) {
        // 无效的输入，直接返回false
        if (StringTool.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_EMAIL);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 判断输入的字符串是否是手机号码格式
     * 
     * @param src 待判断的输入字符串
     * @return True:是合法的手机号码;False:不是合法的手机号码
     */
    public static boolean isValidMobile(String src) {
        // 无效的输入，直接返回false
        if (StringTool.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 判断输入的字符串是否是合法的固话
     * 
     * @param src 待判断的输入字符串
     * @return True:合法;False:不合法
     */
    public static boolean isValidPhone(String src) {
        // 无效的输入，直接返回false
        if (StringTool.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_PHONE);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 判断输入的字符串是否是合法的支付宝登录号
     * <p>
     * 支付宝登录号有两种格式。其一是手机号码；其二是Email（长度未限制）
     * @param src 待判断的输入字符串
     * @return True:是合法的登录号;False:不是合法的登录号
     */
    public static boolean isVliadLogonId(String src) {
        // 无效的输入，直接返回false
        if (StringTool.isBlank(src)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_LOGON_ID);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 判断是否是合法的流水号，标准:流水号为16位纯数字
     * @param src 待判断的输入字符串
     * @return true是合法的流水号;false表示不是合法的流水号
     */
    public static boolean isValidBizNo(String src) {
        // 输入为空则直接返回false
        if (StringTool.isBlank(src)) {
            return false;
        }

        Pattern p = Pattern.compile(REGEX_VALIDATE_BIZ_NO);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 判断是否是合法的金额，标准:<br/>
     * <ul>
     * <li>不为空</li>
     * <li>允许3个连续数字用,分隔</li>
     * <li>允许小数点</li>
     * <li>小数位允许超过多为的数字(多余2位将四舍五入)</li>
     * <li>允许正负金额</li>
     * </ul>
     * @param src 待判断的输入字符串
     * @return true表示是合法的金额;false表示不是合法的金额
     */
    public static boolean isValidMoney(String src) {
        // 无效的输入，直接返回false
        if (StringTool.isBlank(src)) {
            return false;
        }

        Pattern p = Pattern.compile(REGEX_VALIDATE_MONEY);
        Matcher pm = p.matcher(src);
        return pm.matches();
    }

    /**
     * 第二种判断是否是合法的金额的方法，利用转化为Money对象的正确与否。注意:<br/>
     * 这样不能判别,分隔的多个数字情形，只是全部忽略掉。<li>
     * @param src 待判断的输入字符串
     * @return true表示是合法的金额;false表示不是合法的金额
     */
    public static boolean isValidMoney2(String src) {
        // 无效的输入，直接返回false
        if (StringTool.isBlank(src)) {
            return false;
        }

        String inSrc = StringTool.replaceChars(src, ",", "");

        // 全部是,的，直接返回false
        if (StringTool.isBlank(inSrc)) {
            return false;
        }

        try {
            new Money(inSrc);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // just for test
    public static void main(String[] args) {
        System.out.println(isValidUserName("中.和")); // true
    }
}
