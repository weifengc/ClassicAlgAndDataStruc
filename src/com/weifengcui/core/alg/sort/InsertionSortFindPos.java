package com.weifengcui.core.alg.sort;

import com.weifengcui.core.API.SortAPI;
import com.weifengcui.core.testcase.TestArray;
import com.weifengcui.core.testcase.Tools;

import java.util.Arrays;

/**
 * Created by weifengc on 7/1/16.
 */
public class InsertionSortFindPos implements SortAPI {


    public static void main(String[] args){
        int[] arr = TestArray.intArray.clone();
        new InsertionSortFindPos().sort(arr);

        Tools.info("InsertionSort with find pos");
        Tools.info("original :%s\nsorted :%s",
                Arrays.toString(TestArray.intArray),
                Arrays.toString(arr));


    }



    @Override
    public void sort(int[] arr) {
        //idea is to find the right spot for i, and then move everything to right

        if(arr == null || arr.length == 0){
            return;
        }

        for(int i = 1; i < arr.length; i++){
            //find the right pos
            int j = i-1;
            while(j >=0 && arr[j] > arr[i]){
                j--;
            }

            //if j < 0, then i should be 0
            if(j <0){
                // 0 to i-1 move to 1 to i , a[0] = a[i]
                int temp = arr[i];
                moveToRight(arr, 0, i-1, 1);
                arr[0] = temp;
            }else {
                //move j + 2 , to i - 1 , 1 ,   arr[j+1] = i
                int temp = arr[i];
                moveToRight(arr, j+2, i-1, 1);
                arr[j+1]  = temp;
            }

        }

    }


    private void moveToRight(int[] arr, int start,int end, int pos){
        if(start > end){
            return;
        }


        if(pos > 0){
            //move to right, start from end
            for(int i = end; i >= start; i --){
                arr[i + pos] = arr[i];
            }
        }else{
            return;
        }
    }


}
