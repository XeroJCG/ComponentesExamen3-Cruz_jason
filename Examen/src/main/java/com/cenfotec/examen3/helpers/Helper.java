package com.cenfotec.examen3.helpers;

import java.util.regex.Pattern;

public class Helper {

    public static boolean like(final String str, final String expr) {
        String regex = quotemeta(expr);
        regex = regex.replace("_", ".").replace("%", ".*?");
        Pattern p = Pattern.compile(regex,
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        return p.matcher(str).matches();
    }

    public static String quotemeta(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String cannot be null");
        }

        int len = s.length();
        if (len == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder(len * 2);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if ("[](){}.*+?$^|#\\".indexOf(c) != -1) {
                sb.append("\\");
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
