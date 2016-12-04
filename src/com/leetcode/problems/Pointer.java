package com.leetcode.problems;

import com.weifengcui.core.testcase.Tools;

import java.util.Arrays;

/**
 * Created by weifengc on 8/24/16.
 */
public class Pointer {
    public static void main(String[] args){
        int[] arr = {1,2,3};
        Tools.info(Arrays.toString(arr));
        method(arr);
        Tools.info(Arrays.toString(arr));
    }


    private static void method(int[] arr){
        int[] newArr = {5,6};
        arr = newArr;
    }

}
