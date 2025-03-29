package cn.violin.common.utils;

import java.time.format.DateTimeFormatter;

public class CommonConstant {

    /* 共通用　定数　false */
    public final static String FALSE_FLAG = "0";
    /* 共通用　定数　true */
    public final static String TRUE_FLAG = "1";
    /* 共通用　定数　undefined */
    public final static String UNDEFINED_FLAG = "2";
    /* 共通用　定数　undefined */
    public final static int AUTHORITY_LEVEL_TWO  = 2;

    public final static String LIKE_FIX = "%";

    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:SS";
    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmSS";

    public final static DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern(YYYY_MM_DD);
    public final static DateTimeFormatter FORMATTER_DATETIME = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS);
    public final static DateTimeFormatter UPDATE_DATETIME = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);

    // COMMON COLUMN
    public final static String LAST_UPDATE_DATETIME = "updateDateTime";

    // error message
    public final static String ERROR_INFO_1 = "token is wrong";
    public final static String ERROR_INFO_2 = "authorization info is null or empty";
    public final static String ERROR_INFO_3 = "tenantId info is null or empty";


}
