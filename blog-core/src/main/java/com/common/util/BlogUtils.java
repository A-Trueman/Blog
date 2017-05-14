package com.common.util;



import org.apache.commons.lang3.SystemUtils;

import java.util.UUID;

/**
 * Created by Lincg on 2017/5/13.
 */
public final class BlogUtils {


    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        return s.substring(0,8) + s.substring(9,13) + s.substring(14,18) + s.substring(19,23) + s.substring(24);
    }


    public static String[] getUUID(int num) {
        if (num < 1) {
            return null;
        }
        String[] ss = new String[num];

        for (int i = 0; i < num; i ++) {
            ss[i] = getUUID();
        }

        return ss;
    }

//    public static void main(String[] agrs) {
//        System.out.println(getUUID());
//    }
}
