package codJam;

/**
 * Created by weifengc on 4/17/17.
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            int m = in.nextInt();
            PancakeFlipper pf = new PancakeFlipper(input, m);
            int step = pf.minSteps();
            System.out.println("Case #" + i + ": " + (step == -1 ? "IMPOSSIBLE" : step));
        }
    }
}

