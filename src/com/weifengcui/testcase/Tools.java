package com.weifengcui.testcase;



/**
 * Created by weifengc on 6/24/16.
 */
public class Tools {
    public static void info(Object object){
        System.out.println(object);
    }

    public static void info(String str, Object... objects){
        info(String.format(str,objects));
    }
}
