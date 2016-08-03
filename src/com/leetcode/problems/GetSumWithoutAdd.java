package com.leetcode.problems;

/**
 * Created by weifengc on 7/13/16.
 */
public class GetSumWithoutAdd {
    /**
     * Return the sum of two int, without using + or -
     */
    public static void main(String[] args){
        int[] a = {1,2,3,-3};
        int[] b = {2,10,6,2};

        for(int i = 0; i < a.length; i++){
            System.out.println(String.format("sum of %d and %d is %d",
                    a[i], b[i], new GetSumWithoutAdd().getSum(a[i], b[i])));
        }


        //===================nagetive binarystring ============

        int[] neg ={-1,-2,-3,-4,-5,-6};
        for(int i :neg){
            System.out.println(Integer.toBinaryString(i));
        }

        // -1 + 1 = 1 000000000...0000
        // -1 +1 =


    }

    //a is bigger than b
    private String minus(String a, String b){
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int len = 32;
        char[] fullA = new char[len];
        char[] fullB = new char[len];
        char[] result = new char[len];

        System.arraycopy(charA,0, fullA,len-charA.length, charA.length);
        System.arraycopy(charB,0, fullB, len-charB.length, charB.length);
        boolean borrow = false;
        for(int i = len-1; i >= 0; i-- ){
            char char1 = fullA[i];
            char char2 = fullB[i];


        }
        return new String(result);

    }






    private String add(String a, String b){
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int len = 32;
        char[] fullA = new char[len];
        char[] fullB = new char[len];
        char[] result = new char[len];

        System.arraycopy(charA,0, fullA,len-charA.length, charA.length);
        System.arraycopy(charB,0, fullB, len-charB.length, charB.length);
        char char3 = '0';
        for(int i = len-1; i >= 0; i-- ){
            char char1 = fullA[i];
            char char2 = fullB[i];
            int num_one = numOfOne(char1,char2,char3);
            result[i] = (char) ('0'+ (num_one % 2));
            char3 = (char)('0'+( num_one /2));

        }
        return new String(result);
    }


    private int numOfOne(char a, char b, char c){
        int sum = 0;
        if(a == '1'){
            sum++;
        }
        if(b== '1'){
            sum++;
        }
        if(c =='1'){
            sum++;
        }
        return sum;
    }



    public int getSum(int a, int b){
        return method1(a,b);
    }


    /**
     * method 1, change a and b to binay string
     */

    private int method1(int a, int b){
        String s1  = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);
        String res = add(s1,s2);

        System.out.println("s1  is "+s1);
        System.out.println("s2  is "+s2);
        System.out.println("res is "+res);
        return Integer.parseUnsignedInt(res, 2);
    }




}
