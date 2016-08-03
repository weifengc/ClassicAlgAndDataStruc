package com.weifengcui.core.alg.string;

/**
 * Created by weifengc on 8/3/16.
 */
public class Permutations {
    //this is copied from the book Programming Interview exposed
    //https://www.amazon.com/Programming-Interviews-Exposed-Secrets-Landing/dp/1118261364/ref=sr_1_1?ie=UTF8&qid=1470265326&sr=8-1&keywords=programming+interviews+exposed

    private boolean[] used;
    private StringBuilder out = new StringBuilder();
    private final String in;


    public Permutations(final String str){
        in = str;
        used = new boolean[in.length()];
    }

    public void permute(){
        if(out.length() == in.length()){
            System.out.println( out );
            return;
        }

        for( int i = 0; i < in.length(); i++) {
            if (used[i]) continue;
            out.append(in.charAt(i));
            used[i] = true;
            permute();
            used[i] = false;
            out.setLength(out.length() - 1);
        }
    }

    //----------------------------------tests--------------------------
    public static void main(String[] args){
        String str = "abc";
        Permutations permutations = new Permutations(str);
        permutations.permute();
    }

}
