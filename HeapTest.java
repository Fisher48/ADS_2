import org.junit.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    @Test
    public void SampleTest(){
        Heap heap = new Heap();
        int[] a = {1,2,3,4,5,6};
        heap.MakeHeap(a,2);
        heap.GetMax();
        System.out.println(Arrays.toString(heap.HeapArray));
        heap.Add(10);
        System.out.println(Arrays.toString(heap.HeapArray));
        heap.Add(23);
        System.out.println(Arrays.toString(heap.HeapArray));
        heap.GetMax();
        heap.GetMax();
        System.out.println(Arrays.toString(heap.HeapArray));
    }

}