import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class aBSTTest {

    @Test
    public void SampleTest() {
        aBST aBST = new aBST(3);
        aBST.AddKey(10);
        aBST.AddKey(6);
        aBST.AddKey(1);
        aBST.AddKey(8);
        aBST.AddKey(5);
        assertEquals(null,aBST.FindKeyIndex(3));
        assertEquals(3,aBST.AddKey(1));
        aBST.AddKey(100);
        aBST.AddKey(3);
        assertEquals(-1,aBST.AddKey(3));
        assertEquals(2,aBST.AddKey(100));
    }

}