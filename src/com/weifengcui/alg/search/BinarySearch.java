package com.weifengcui.alg.search;

import com.weifengcui.testcase.TestArray;
import com.weifengcui.testcase.Tools;

import java.util.Arrays;

/**
 * Created by weifengc on 6/24/16.
 */
public class BinarySearch {

    public static void main(String[] args) {
        //test case
        int[] arr1 = TestArray.sortedIntArray;
        int[] targets = {0, 2, 4, 9};

        for (int target : targets) {
            Tools.info("Search %d in sorted array %s " +
                            "positions is %d ",
                    target, Arrays.toString(arr1),
                    binarySearch(arr1, target));
        }
    }

    /**
     * Binary search, find the position of the target in an array.
     *
     * @param sortedArr this should be a sorted array.
     * @param target    target number.
     * @return position, -1 if not in the array.
     */
    public static int binarySearch(int[] sortedArr, int target) {
        /**
         * Check boundary.
         * Sort the array, it must be sorted first.
         * Create a recursive method, with start and end point.
         * Find middle value, if less than middle value, search in left, or search in right.
         */

        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }


        int start = 0;
        int end = sortedArr.length - 1; // always use the position, which will not cause array out of boundary error.

        return binarySearch(sortedArr, target, start, end);

    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        /**
         * Base case:
         * 1. if start > end, return -1, can not find the target
         */

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2; // to avoid start + end is bigger than Integer.MAX_VALUE

        //compare middle value with target
        if (target == arr[middle]) {
            return middle;
        } else if (target < arr[middle]) {
            //search in the left
            return binarySearch(arr, target, start, middle - 1); // We already compared with middle, so make it middle -1
        } else {
            return binarySearch(arr, target, middle + 1, end);
        }
    }


}





















