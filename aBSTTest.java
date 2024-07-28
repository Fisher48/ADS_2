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

    @Test
    public void addInEmptyArray(){
        aBST emptyBst = new aBST(3);
        assertEquals(0,emptyBst.AddKey(50));
        assertEquals(2,emptyBst.AddKey(75));
        assertEquals(6,emptyBst.AddKey(85));
        assertEquals(14,emptyBst.AddKey(90));
        assertEquals(-1,emptyBst.AddKey(95));
    }

    @Test
    public void sizeBSTTest(){
        aBST bst3depth = new aBST(3);
        aBST bst4depth = new aBST(4);
        aBST bst5depth = new aBST(5);
        aBST bst6depth = new aBST(6);
        assertEquals(15,bst3depth.Tree.length);
        assertEquals(31,bst4depth.Tree.length);
        assertEquals(63,bst5depth.Tree.length);
        assertEquals(127,bst6depth.Tree.length);
    }

}