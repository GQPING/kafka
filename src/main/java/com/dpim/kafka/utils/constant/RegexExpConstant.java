package com.dpim.kafka.utils.constant;

/**
 * 校验常用正则表达式常量
 * @author cxw
 * @date 2022/1/5
 */
public class RegexExpConstant {

    /**
     * 校验手机号（11位），正则表达式
     */
    public static String REGEX_PHONE_EXP_1 = "^1(3|4|5|6|7|8|9)\\d{9}$";

    /**
     * 校验银行卡号（首位非0，长度6-30位），正则表达式
     */
    public static String REGEX_BANK_EXP_1 = "^([1-9]{1})(\\d{5,29})$";

    /**
     * 校验银行卡号（开头两位,长度12-19），正则表达式
     */
    public static String REGEX_BANK_EXP_2 = "^(10|18|30|35|37|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58|60|62|65|68|69|84|87|88|94|95|98|99)(\\d{10,17})$";

    /**
     * 校验占比整数（0-100，含0和100），正则表达式
     */
    public static String REGEX_RATE_EXP_1 = "^(?:[1-9]?\\d|100)$";

    /**
     * 校验非负整数（正整数和0），正则表达式
     */
    public static String REGEX_INT_EXP_1 = "^\\d+$";

    /**
     * 校验金额数字（最多2位小数），正则表达式
     */
    public static String REGEX_MONEY_EXP_2 = "^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{1,2})?$";

    /**
     * 校验金额数字（最多4位小数），正则表达式
     */
    public static String REGEX_MONEY_EXP_4 = "^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{1,4})?$";

    /**
     * 校验金额数字（最多6位小数），正则表达式
     */
    public static String REGEX_MONEY_EXP_6 = "^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{1,6})?$";

}
