package server.utils;

import common.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * 获取不同类型的请求参数
 *
 * @author Chris
 * 2018/4/20 19:30
 * @see server.utils
 */
public class RequestUtils {

    /**
     * 获取String参数
     *
     * @param request HttpServletRequest
     * @param key String
     * @return String
     */
    public static String getString(HttpServletRequest request, String key) {
        String val = request.getParameter(key);
        if (StringUtils.isEmpty(val)) {
            return "";
        }
        return val.trim();
    }

    /**
     * 获取整型参数
     *
     * @param request HttpServletRequest
     * @param key String
     * @return int
     */
    public static int getInt(HttpServletRequest request, String key) {
        String val = request.getParameter(key);
        if (!StringUtils.isEmpty(val)) {
            return Integer.parseInt(val.trim());
        }
        return 0;
    }

    /**
     * 获取boolean 类型参数
     *
     * @param request HttpServletRequest
     * @param key String
     * @return boolean
     */
    public static boolean getBoolean(HttpServletRequest request, String key) {
        String val = request.getParameter(key);
        if (StringUtils.isEmpty(val)) {
            return false;
        }
        val = val.trim();
        return "1".equals(val) || "true".equals(val);
    }

}
