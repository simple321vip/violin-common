package cn.violin.home.common.utils;

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

    public final static DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public final static DateTimeFormatter FORMATTER_DATETIME = DateTimeFormatter.ofPattern("yyyyMMddHHmmSS");
    public final static DateTimeFormatter UPDATE_DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");

    public final static String WORD_1 = "你的世界";
    public final static String WORD_2 = "从这里开始";

    // common column views
    public final static String COLUMN_ORDER = "order";

    // error message
    public final static String ERROR_INFO_1 = "token is wrong";
    public final static String ERROR_INFO_2 = "authorization info is null or empty";
    public final static String ERROR_INFO_3 = "tenantId info is null or empty";


}
