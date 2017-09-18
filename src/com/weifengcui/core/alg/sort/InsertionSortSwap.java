package com.weifengcui.core.alg.sort;

import com.weifengcui.core.API.SortAPI;
import com.weifengcui.core.testcase.TestArray;
import com.weifengcui.core.testcase.Tools;

import java.util.Arrays;

/**
 * Created by weifengc on 7/1/16.
 */
public class InsertionSortSwap implements SortAPI {
    public static void main(String[] args){
        int[] arr = TestArray.intArray.clone();

        new InsertionSortSwap().sort(arr);

        Tools.info("original :%s\nsorted :%s",
                Arrays.toString(TestArray.intArray),
                Arrays.toString(arr));

    }



    @Override
    public void sort(int[] arr) {
        //swap i with every larger one in its left, from right to left.

        if(arr == null || arr.length == 0){
            return;
        }

        for(int i = 1; i < arr.length; i++){

            //its left
            for(int j = i - 1; j >= 0; j-- ){
                //if i < j
                if(arr[i] < arr[j]){
                    //swap, then i = j
                    swap(arr,i, j);
                    i = j;
                }
            }
        }
    }


    private void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public void sort2(int[] arr){

        for (int i = 1; i < arr.length; i ++){
            int j = i;
            while(arr[j] < arr[j-1]){
                swap(arr, j, j -1);
                j--;
            }
        }

    }
}
