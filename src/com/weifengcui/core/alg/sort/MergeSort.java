package com.weifengcui.core.alg.sort;

import com.weifengcui.core.API.SortAPI;
import com.weifengcui.core.testcase.TestArray;
import com.weifengcui.core.testcase.Tools;

import java.util.Arrays;

/**
 * Created by weifengc on 7/1/16.
 */
public class MergeSort implements SortAPI {
    private int[] copy_arr  =null;

    public static void main(String[] args){
        int[] arr = TestArray.intArray.clone();
        new MergeSort().sort(arr);

        Tools.info("original: %s\nsorted: %s",
                Arrays.toString(TestArray.intArray),
                Arrays.toString(arr));
    }


    @Override
    public void sort(int[] arr) {
        //sort left, sort right, merge
        if(arr == null || arr.length == 0){
            return;
        }

        copy_arr = arr.clone();
        sort(arr, 0, arr.length-1);


    }

    private void sort(int[] arr, int lo, int hi){
        //boundary
        if(lo >= hi){
            return;
        }

        int mid = lo +(hi -lo)/2;
        sort(arr, lo, mid );
        sort(arr, mid+1, hi);
        merge(arr, lo, hi, mid);
    }


    //mid belongs to the left
    private void merge(int[] arr, int lo, int hi, int mid){
        copy_arr = arr.clone();

        //from copy_arr to arr
        int i = lo;
        int j = mid+1;
        for(int k = lo; k <= hi; k++){
            if(i > mid){
                arr[k] = copy_arr[j];
                j++;
                continue;
            }

            if( j > hi){
                arr[k] = copy_arr[i];
                i++;
                continue;
            }

            if(copy_arr[i] <= copy_arr[j]){
                arr[k] = copy_arr[i];
                i++;
            }else{
                arr[k] = copy_arr[j];
                j++;
            }
        }
    }





}
