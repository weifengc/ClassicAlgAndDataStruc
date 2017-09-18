package codJam.TidyNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;

/*
https://code.google.com/codejam/contest/3264486/dashboard#s=p1
Build:
cd src
javac codJam/TidyNumber/TidyNumber.java

Run:
java codJam.TidyNumber.TidyNumber

java codJam.TidyNumber.TidyNumber < ~/Downloads/B-small-practice.in
java codJam.TidyNumber.TidyNumber < ~/Downloads/B-large-practice.in



 */
public class TidyNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String l = in.next();
            TidyNumber tn = new TidyNumber(new BigInteger(l));
            System.out.println("Case #" + i + ": " + tn.res2());
        }
    }

    private BigInteger givenNum;
    public TidyNumber(BigInteger givenNum){
        this.givenNum = givenNum;
    }

    public BigInteger res(){
        return lastTidy(givenNum);
    }

// FIXME :   111111111111111110  java.lang.StackOverflowError
    private BigInteger lastTidy(BigInteger num){
        if (isTidy(num.toString())) return num;
        return lastTidy(num.subtract(BigInteger.ONE));
    }


    private boolean isTidy(String str){
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) >  str.charAt(i + 1)) return false;
        }
        return true;
    }

//    ############## method 2 ############################

    public BigInteger res2(){
        return lastTidy2(givenNum);
    }

    private BigInteger lastTidy2(BigInteger num){
        int it = isTidy2(num);
        if(it == 0) return num;
        return lastTidy2(num.subtract(BigInteger.valueOf((int) Math.pow(10, it - 1))));
    }


    private int isTidy2(BigInteger bigInteger){
        return isTidy2(bigInteger.toString());
    }

    /**
     * Check whether it is tidy. If so, return 0, or return its digit pos, 1 to string.length - 1
     * @param str
     * @return
     */
    private int isTidy2(String str){
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) >  str.charAt(i + 1)) return str.length() - 1 - i;
        }
        return 0;
    }


}
