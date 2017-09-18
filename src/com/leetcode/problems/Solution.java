package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args){
        System.out.println("hello");
        Excel excel  = new Excel(3, 'C');
        String[] ss = {"A2"};
        excel.sum(1, 'A', ss);
        excel.set(2, 'A', 1);
        excel.get(1, 'A');
    }
}

 class Excel {
    List<Map<Character, Cell>> sheet;


    public Excel(int H, char W) {
        sheet = new ArrayList<Map<Character, Cell>>(H);
        for(int i = 0 ; i < H; i++){
            sheet.add( new HashMap<Character, Cell>());
        }
    }

    public void set(int r, char c, int v) {
        r--;
        addToSheet( r, c, new IntCell(v) );
    }

    public int get(int r, char c) {
        r--;
        Cell cell = getCell(r, c);
        return (cell == null) ? 0 : cell.getVal();
    }

    public int sum(int r, char c, String[] strs) {
        r--;
        addToSheet(r, c, new FunCell(strs) );
        return get(++r, c);
    }


    private void addToSheet(int r, char c, Cell cell){
        if(sheet.get(r) == null ){
            Map<Character, Cell> map = new HashMap<>();
            sheet.set(r, map);
        }
        sheet.get(r).put(c, cell);
    }

    private Cell getCell(int r, char c){
        if(sheet.get(r) == null ) return null;
        return sheet.get(r).get(c);
    }

    private List<Cell> getCells(int r, char c1, char c2){
        if(sheet.get(r) == null ) return new ArrayList<Cell>();
        List<Cell> list = new ArrayList<>();
        for(char c = c1; c <= c2; c++){
            Cell cell = sheet.get(r).get(c);
            if(cell != null) list.add(cell);
        }
        return list;
    }

    List<Cell> toCellList(String[] strs){
        List<Cell> list = new ArrayList<>();
        for(String s : strs){
            list.addAll(toCellList(s) );
        }
        return list;
    }

    List<Cell> toCellList(String s){
        List<Cell> list = new ArrayList<>();
        if( !s.contains(":") ){
            Cell cell = getCell( r(s) , c(s) );
            if(cell != null) list.add(cell);
            return list;
        }

        String[] ss = s.split(":");
        int r1 = r(ss[0] );
        char c1 = c(ss[0]);
        int r2 = r(ss[1]);
        char c2 = c(ss[1]);

        if(r1 == r2){
            list.addAll( getCells(r1, c1, c2) );
            return list;
        }

        for(int i = r1 + 1; i < r2; i++){
            list.addAll(getCells( i, 'A', 'Z') );
        }
        list.addAll(getCells(r1, c1, 'Z'));
        list.addAll(getCells(r2, 'A', c2) );
        return list;
    }

    int r(String s){
        return s.charAt(1) - '0';
    }

    char c(String s){
        return s.charAt(0);
    }





    interface Cell{
        int getVal();
    }

    class IntCell implements Cell{
        int val;
        IntCell(int val){
            this.val = val;
        }
        public int getVal(){
            return val;
        }
    }


    class FunCell implements Cell{
        String[] strs;
        FunCell(String[] strs){
            this.strs = strs;
        }
        public int getVal(){
            int sum = 0;
            for(Cell c : toCellList(strs) ){
                sum += c.getVal();
            }
            return sum;
        }
    }





}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */