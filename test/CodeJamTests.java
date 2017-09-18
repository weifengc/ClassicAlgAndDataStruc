import codJam.TidyNumber.TidyNumber;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weifengc on 4/20/17.
 */
public class CodeJamTests {

    @Test
    public void test_tidy_number(){
        Map<Long, Long> map = new HashMap<>();
        map.put((long)132, (long)129);
        map.put((long)1000, (long)999);
        map.put((long)7, (long)7);
        map.put(Long.parseLong("111111111111111110"), Long.parseLong("111111111111111110"));

        for(Long key : map.keySet()){
//            assert (new TidyNumber(key).res() == map.get(key));
        }
    }
}
