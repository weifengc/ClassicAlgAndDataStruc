package codJam;

/**
 * Created by weifengc on 4/17/17.
 */
public class PancakeFlipper {
    char DOWN = '-';
    char UP = '+';

    private String input;
    private int k;

    public PancakeFlipper(String input, int k) {
        this.input = input;
        this.k = k;
    }

    public int minSteps() {
        //loop through left to right
        //if char is '-' , flip
        int res =0;
        char[] arr = input.toCharArray();
        for(int i = 0; i + k - 1< arr.length; i++){
            if(arr[i] == DOWN) {
                flip(arr, i);
                res ++;
            }
        }
        //check whether last k is up or down
        for(int i =0 ; i < k; i++){
            if(arr[arr.length - 1 - i] == DOWN) return -1;
        }
        return res;
    }
    private void flip(char[] arr, int pos){
        for(int i = pos; i < pos + k; i ++){
            arr[i] = (arr[i] == DOWN) ? UP : DOWN;
        }
    }


}
