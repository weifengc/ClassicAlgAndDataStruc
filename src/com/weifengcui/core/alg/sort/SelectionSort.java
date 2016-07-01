package com.weifengcui.core.alg.sort;

import com.weifengcui.core.API.SortAPI;
import com.weifengcui.core.testcase.TestArray;
import com.weifengcui.core.testcase.Tools;

import java.util.Arrays;

/**
 * Created by weifengc on 7/1/16.
 */
public class SelectionSort implements SortAPI {

    public static void main(String[] args){
        int[] arr = TestArray.intArray.clone();

        new SelectionSort().sort(arr);

        Tools.info("original: %s, sorted: %s", Arrays.toString(TestArray.intArray),
                Arrays.toString(arr));


    }


    @Override
    public void sort(int[] arr) {
        //find the smallest in right, swap with i.
        if(arr == null || arr.length ==0 ){
            return;
        }


        for(int i = 0; i < arr.length - 1; i++){
            //the last one does not need to sort
            int smallest = i;
            for(int j = i+1; j < arr.length; j++){
                   //find the smallest
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
}
