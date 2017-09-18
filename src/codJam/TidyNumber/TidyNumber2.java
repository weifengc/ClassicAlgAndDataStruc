package codJam.TidyNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;

/*
https://code.google.com/codejam/contest/3264486/dashboard#s=p1
Build:
cd src
javac codJam/TidyNumber/TidyNumber2.java

Run:
java codJam.TidyNumber.TidyNumber2

java codJam.TidyNumber.TidyNumber2 < ~/Downloads/B-small-practice.in
java codJam.TidyNumber.TidyNumber2 < ~/Downloads/B-large-practice.in



 */
public class TidyNumber2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            long l = in.nextLong();
            TidyNumber2 tn = new TidyNumber2();
            System.out.println("Case #" + i + ": " + tn.lastTidy(l));
        }
    }


    public long lastTidy(long num){
        int pos = isTidy(num);
        if(pos == 0)  return num;
        return lastTidy(num - 1);
    }




//    /**
//     * Return 0 if true. Return the digit position if not.
//     * @param num
//     * @return
//     */
//    private int isTidy(long num){
//        int len = digitsLen(num);
//        for(int i = len; i > 1; i--){
//            if(digitOf(num, i) > digitOf(num, i - 1)) return i;
//        }
//        return 0;
//    }

    private int isTidy(long num){
        String str = Long.valueOf(num).toString();
        for(int i = 0; i < str.length() - 1; i ++){
            if(str.charAt(i) > str.charAt(i + 1)) return str.length() - i;
        }
        return 0;
    }


    /**
     * right to left, 10^0 is 1
     * @param num
     * @param pos
     * @return
     */
    private int digitOf(long num, int pos){
        return (int) num / (int) Math.pow(10, pos - 1) % (int) Math.pow(10, pos);
    }

    private int digitsLen(long num){
        if(num < 10) return 1;
        return  1 + digitsLen(num / 10);
    }

}
