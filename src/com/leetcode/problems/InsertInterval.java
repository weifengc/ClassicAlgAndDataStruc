package com.leetcode.problems;

import java.util.*;

/**
 * Created by weifengc on 3/15/17.
 */
public class InsertInterval {

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class SortedInterval implements Comparable<SortedInterval> {
        Interval interval;

        public SortedInterval(Interval interval) {
            this.interval = interval;
        }

        public boolean canMerge(Interval newInteval){
            if(this.interval.start >= newInteval.start && this.interval.start <= newInteval.end) return true;
            if(this.interval.end >= newInteval.start && this.interval.end <= newInteval.end) return true;
            return false;
        }

        public Interval merge(Interval newInterval){
            int start = Math.min(this.interval.start, newInterval.start);
            int end = Math.max(this.interval.end, newInterval.end);
            return new Interval(start, end);
        }

        @Override
        public int compareTo(SortedInterval o) {
            return this.interval.start - o.interval.start;
        }
    }


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<SortedInterval> list = new ArrayList<>();
        for(Interval interval : intervals){
            list.add(new SortedInterval(interval));
        }
        list.add(new SortedInterval(newInterval));

        //sort list
        Collections.sort(list);

        List<Interval> res = new ArrayList<>();
        res.add(list.get(0).interval);

        for(int i = 1; i < list.size(); i++){
            Interval pre = res.get(res.size() - 1);
            if(list.get(i).canMerge(pre)){
                res.remove(res.size() - 1);
                res.add(list.get(i).merge(pre));
            }else {
                res.add(list.get(i).interval);
            }
        }

        return res;
    }



    public static void main(String[] args){
        String str = "1,2;3,5;6,7;8,10;12,16";
        String s = "4,9";
        List<Interval> list = new InsertInterval().toIntervalList(str);
        Interval interval = new InsertInterval().toInterval(s);

        List<Interval> res = new InsertInterval().insert(list, interval);
        print(res);

    }

    private static void print(List<Interval> list){
        for (Interval interval : list){
            System.out.println(String.format("[%d , %d] ", interval.start, interval.end));
        }
    }



    private Interval toInterval(String str){
        String[] arr = str.split(",");
        int start = Integer.parseInt(arr[0]);
        int end = Integer.parseInt(arr[1]);
        return new Interval(start, end);
    }

    private List<Interval> toIntervalList(String str){
        String[] arr = str.split(";");
        List<Interval> list = new ArrayList<>();
        for(String s : arr){
            list.add(toInterval(s));
        }
        return list;
    }


}
