package com.ihrm.common.utils;

import org.springframework.util.Assert;

/**
 * @author wuzebin
 * @title: StringUtils
 * @projectName ihrm_parent
 * @description: TODO
 * @date 2019/9/1917:52
 */
public class StringUtils {
    public static String  EMPTY = "";
    /**
     * 字符串首字母 转大写
     * @param str
     * @return
     */
    public static String firstLetterUpper(String str) {
        Assert.hasText(str);
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return String.valueOf(ch);
    }
}
