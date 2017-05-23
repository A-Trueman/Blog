package com.common.util;



import org.apache.commons.lang3.SystemUtils;

import java.sql.Timestamp;
import java.util.Date;
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

    public static Long getTime() {
        return System.currentTimeMillis();
    }


    /**
     * 从html中提取纯文本
     *
     * @param htmlString html字符串
     *
     * @return 文本内容
     */
    public static String html2Text(String htmlString) {
        String regEx_script = "(?i)<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
        String regEx_style = "(?i)<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
        htmlString = htmlString.replaceAll(regEx_script, "").replaceAll(regEx_style, "")
                .replaceAll(regEx_html, "").replaceAll("[ ]+", "")
                .replaceAll("\\s*|\t|\r|\n", "");
        return htmlString;
    }


    public static String longTime2Text(long time) {
	    Date date = new Date(time);
        return date.toString();
    }

    public static void main(String agrs[]) {
//    	String str = longTime2Text(System.currentTimeMillis());
//    	String[] string = str.split(" ");
//    	for (String s : string) {
//    		System.out.println(s);
//	    }
    }
}
