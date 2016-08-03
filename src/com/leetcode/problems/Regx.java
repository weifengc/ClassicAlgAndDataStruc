package com.leetcode.problems;

/**
 * Created by weifengc on 7/19/16.
 */
public class Regx {
    public static void main(String[] args){
        String[] ss = {"10000","000000","100000"};

        for(String s: ss){
            info(s);
            boolean b1 = s.matches("1[0]+");
            info("only contains 1 and 0 " +b1);

        }


    }

    private static void info(Object o){
        System.out.println(o);
    }

}
