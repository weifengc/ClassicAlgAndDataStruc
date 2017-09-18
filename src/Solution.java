import java.util.*;

public class Solution {
 public static void main(String[] args){
     int num = 12;
     String binary = Integer.toBinaryString(12);
     String eight = leadingZeroes(8 - binary.length());
     System.out.println(eight + binary);

 }

 static String leadingZeroes(int len){
     return String.format("%0" + len + "d", 0);
 }




}