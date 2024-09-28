package com.sangyunpark.smileboard.user.utils;

import jakarta.servlet.http.HttpSession;

public class SessionUtils {

    private static final String LOGIN_DEFAULT = "LOGIN_DEFAULT";
    private static final String LOGIN_ADMIN = "LOGIN_ADMIN";

    public static String getLoginDefaultId(HttpSession session) {
        return (String) session.getAttribute(LOGIN_DEFAULT);
    }

    public static String getLoginAdminId(HttpSession session) {
        return (String) session.getAttribute(LOGIN_ADMIN);
    }

    public static void setLoginDefaultId(HttpSession session, String id) {
        session.setAttribute(LOGIN_DEFAULT, id);
    }

    public static void setLoginAdminId(HttpSession session, String id) {
        session.setAttribute(LOGIN_ADMIN, id);
    }

    public static void clear(HttpSession session) {
        session.invalidate();
    }
}
