package com.weifengcui.core.alg.search;

import com.weifengcui.core.API.BinarySearchAPI;
import com.weifengcui.core.API.BinarySearchDuplicateAPI;
import com.weifengcui.core.testcase.TestArray;
import com.weifengcui.core.testcase.Tools;

import java.util.Arrays;

/**
 * Created by weifengc on 6/24/16.
 */
public class BinarySearchIterative implements BinarySearchAPI, BinarySearchDuplicateAPI {


    /**
     * Use two pointer, one as start one as end.
     * Compare with the middle value, move the pointer to make the range smaller
     *
     * @param sortedArr sorted array.
     * @param target    target value
     * @return position of the value, or -1 if the value is not in the array.
     */
    @Override
    public int binarySearch(int[] sortedArr, int target) {
        //check boundary
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = sortedArr.length - 1;

        while (start <= end && start <= sortedArr.length - 1 && end >= 0) {
            int midPos = start + (end - start) / 2; //start + end may be out of boundary

            if (target == sortedArr[midPos]) {
                return midPos;
            } else if (target < sortedArr[midPos]) {
                end = midPos - 1;
            } else {
                start = midPos + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] sortedArr = TestArray.sortedIntArray;
        int[] targets = {0, 1, 2, 4, 10};

        BinarySearchAPI binarySearchAPI = new BinarySearchIterative();
        BinarySearchDuplicateAPI binarySearchDuplicateAPI = new BinarySearchIterative();
        for (int target : targets) {
            Tools.info("search %d in array %s, pos :%d", target, Arrays.toString(sortedArr),
                    binarySearchAPI.binarySearch(sortedArr, target));

        }

        for (int target : targets) {
            Tools.info("target:%s ...", target);
            Tools.info("search %d in array %s, pos %s", target,
                    Arrays.toString(TestArray.sortedIntArrayWithDuplicate),
                    Arrays.toString(
                            binarySearchDuplicateAPI.binarySearchWithDuplicate
                                    (TestArray.sortedIntArrayWithDuplicate, target)));
        }

    }


    /**
     * When there are duplicates in sortedArr, find out the start and end point of the value.
     * 1. Use similar logic, make two binary search, one for the start point, one for the end point.
     * 2. For the start point, when target == sortedArr[mid], continue search in its left, with the mid point.
     * 3. For the end point, when target equal to mid, continue search in its right.
     *
     * @param sortedArr
     * @param target
     * @return
     */
    @Override
    public int[] binarySearchWithDuplicate(int[] sortedArr, int target) {
        int[] result = {-1, -1};
        int len = sortedArr.length;

        int start = 0;
        int end = len - 1;

        //for the left
        while (start < end - 1) {
            int mid = start + (end - start) / 2;

            if (target == sortedArr[mid]) {
                //search on left
                end = mid;
            } else if (target > sortedArr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // start == end - 1
        // start == end
        if (start == end) {
            if (target == sortedArr[start]) {
                result[0] = start;
            }
        } else {
            if (target == sortedArr[start]) {
                result[0] = start;
            } else if (target == sortedArr[end]) {
                result[0] = end;
            }

        }


        // for the right
        start = 0;
        end = len - 1;

        while (start < end - 1) {
            int mid = start + (end - start) / 2;

            if (target == sortedArr[mid]) {
                //search on right
                start = mid;
            } else if (target > sortedArr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // start == end - 1
        // start == end
        if (start == end) {
            if (target == sortedArr[start]) {
                result[1] = start;
            }
        } else {
            if (target == sortedArr[end]) {
                result[1] = end;
            } else if (target == sortedArr[start]) {
                result[1] = start;
            }

        }


        return result;
    }
}
