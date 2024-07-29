import org.junit.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmsDataStructures2Test {

    @Test
    public void SampleTest(){
        int[] a = new int[15];
        a[0] = 7; a[1] = 3; a[2] = 11; a[3] = 1; a[4] = 5; a[5] = 9;
        a[6] = 13; a[7] = 0; a[8] = 2; a[9] = 4; a[10] = 6; a[11] = 8;
        a[12] = 10; a[13] = 12; a[14] = 14;
        int[] b = new int[15];
        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }
        assertArrayEquals(a,AlgorithmsDataStructures2.GenerateBBSTArray(b));
    }

}