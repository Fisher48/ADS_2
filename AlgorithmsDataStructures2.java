import java.util.*;

public class AlgorithmsDataStructures2 {

    public static int[] createBSTArray(int[] a){
        int[] aBST = new int[a.length];
        for (int i = 0; i < a.length; i++){
            aBST[i] = 0;
        }
        return aBST;
    }
    public static int[] GenerateBBSTArray(int[] a) {
        Arrays.sort(a);
        int[] aBST = createBSTArray(a);
        return genBalanceBSTArray(a, aBST, 0, a.length-1, 0);
    }

    public static int[] genBalanceBSTArray(int[] a, int[] aBST, int start, int end, int i){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        aBST[i] = a[mid];
        genBalanceBSTArray(a, aBST, start, mid - 1, i * 2 + 1);
        genBalanceBSTArray(a, aBST, mid + 1, end, i * 2 + 2);
        return aBST;
    }
}


