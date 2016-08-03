package com.weifengcui.core.Heap;

import com.weifengcui.core.testcase.TestArray;
import com.weifengcui.core.testcase.Tools;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by weifengc on 7/29/16.
 */
public class PriorityQueueExample {
    public static void main(String[] args){

        example();
    }

    //Create a pq to maintain the smallest number in an array.
    private static void example(){
        int[] arr = TestArray.intArray;

        PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length
                ,(i, j)-> i -j);


        Tools.info("input array is %s", Arrays.toString(arr));

        for(int i  : arr){
            pq.add(i);
        }


        while(!pq.isEmpty()) {
            int val = pq.poll();
            Tools.info("current smallest one is %d", val);

        }
    }

}
