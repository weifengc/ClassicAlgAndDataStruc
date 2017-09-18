package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by weifengc on 12/5/16.
 */
public class QueueReconstruction {
    public static void main(String[] args){
        List<int[]> list = new ArrayList<>();
        list.sort(new Comp());
    }

    static class Comp implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        }
    }
}
