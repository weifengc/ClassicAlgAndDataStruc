package com.weifengcui.core.alg.sort;

import com.weifengcui.core.API.SortAPI;
import com.weifengcui.core.testcase.TestArray;
import com.weifengcui.core.testcase.Tools;

import java.util.Arrays;

/**
 * Created by weifengc on 7/1/16.
 */
public class QuickSort implements SortAPI {
    public static void main(String[] args){
        int[] arr = TestArray.intArray.clone();
        new QuickSort().sort(arr);

        Tools.info("original: %s\nsorted: %s",
                Arrays.toString(TestArray.intArray),
                Arrays.toString(arr));
    }


    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length -1);
    }

    private void sort(int[] arr, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int mid = partition(arr, lo, hi);
        sort(arr, lo, mid -1 );
        sort(arr, mid+1, hi);

    }

//    FIXME: this method is not accurate.
    private int partition(int[] arr, int lo, int hi){
        //random arr from lo to hi.
        shuffle(arr, lo, hi);

        int val = arr[lo];
        int left = lo +1;
        int right = hi;
        int pos = lo;

        while(left < right && right >= lo+1 && left <=hi ){
            while (arr[left] < val && left <= hi) left++;
            while (arr[right] >= val && right >= lo+1) right --;


            if(left > hi || right < lo+1){
                break;
            }

            swap(arr, left, right);
            left ++;
            right --;
        }

        if(left > hi){
            moveToLeft(arr,lo+1, hi,1);
            return hi;
        }else if(right < lo+1){
            return lo;
        }


        if(left == right){
            if(val <= arr[right]){
                moveToLeft(arr, lo+1, left -1, 1);
                arr[left - 1] = val;
                pos = left -1;
            }else {
                moveToLeft(arr, lo+1, left, 1);
                arr[left] = val;
                pos = left;
            }
        }else if(left > right){
            //lo  to right move to left by 1
            moveToLeft(arr, lo+1, right, 1);
            arr[right] = val;
            pos = right;
        }
        return pos;
    }

    private void moveToLeft(int[] arr, int start, int end, int pos){
        if(pos <= 0  || start > end){
            return;
        }

        for(int i = start; i <= end; i++){
            arr[i - pos] = arr[i];
        }
    }




    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private void shuffle(int[] arr, int lo, int hi){
        //shuffle the arr from lo to hi
    }


}
