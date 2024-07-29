import org.junit.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class BalancedBSTTest {

    @Test
    public void SampleTest() {
        int[] arr = new int[15];
        for (int i = 14; i > 0; i--) {
            arr[i] = i;
        }
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(arr);
        balancedBST.printTree(balancedBST.Root,0);
        assertEquals(true,balancedBST.IsBalanced(balancedBST.Root));
    }


}