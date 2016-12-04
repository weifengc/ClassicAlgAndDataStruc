package com.leetcode.problems;

import com.weifengcui.core.testcase.Tools;

import java.util.HashSet;

/**
 * Created by weifengc on 8/9/16.
 */
public class HashSetTest {
    /**
     * Question, if I create a new class, implement an equals method, then put two element equals to one hashset, will both
     * of them exist?
     *
     * Answer, only implement equals is not enough, need to implement hashCode.
     *
     */


    public static void main(String[] args) {
        Line l1 = new Line(1, 2);
        Line l2 = new Line(1, 2);
        Line l3 = new Line(2, 1);
        Tools.info("l1 equals l2 : %s", l1.equals(l2));

        HashSet<Line> set = new HashSet<>();
        set.add(l1);
        set.add(l2);
        set.add(l3);

        Tools.info("set size is : %d", set.size());

    }

    static class Line {
        private double k;
        private double b;

        public Line(double k, double b) {
            this.k = k;
            this.b = b;
        }

        //give two point and decide this Line
        public Line formLine(int x1, int y1, int x2, int y2) {
            //y = kx + b so, b  = y -kx , y1 - k * x1 = y2 - k * x2
            //k ( x2 - x1) = y2 - y1

            double k;
            if (x2 - x1 == 0) {
                // this is a vertical line
                k = Double.MAX_VALUE;
            } else {
                k = (y2 - y1) / (x2 - x1);
            }
            double b = y1 - k * x1;
            return new Line(k, b);
        }

        public double getK() {
            return this.k;
        }

        public double getB() {
            return this.b;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Line) {
                return (this.k == ((Line) o).getK()) && (this.b == ((Line) o).getB());
            }
            return false;
        }

        public int hashCode() {
            String str = k+"k"+b+"b";
            return str.hashCode();

        }

    }

}
