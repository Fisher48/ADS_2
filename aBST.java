import java.util.*;

class aBST {

    public Integer Tree []; // массив ключей

    public aBST(int depth) {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = (int) Math.pow(2, depth + 1) - 1;
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) {
            Tree[i] = null;
        }
    }

    public Integer findKey(int key, int ind) {
        if (ind >= Tree.length) {
            return null;
        }
        if (Tree[ind] == null) {
            return ind;
        }
        if (Tree[ind] != null) {
            if (Tree[ind] == key) {
                return -ind;
            }
        }
        if (key < Tree[ind]) {
            ind = ind * 2;
            return findKey(key,ind + 1);
        }
        else if (key > Tree[ind]) {
            ind = ind * 2;
            return findKey(key,ind + 2);
        }
        return null;
    }
    public Integer FindKeyIndex(int key) {
        // ищем в массиве индекс ключа
        return findKey(key,0); // не найден
    }

    public int AddKey(int key) {
        // добавляем ключ в массив
        Integer x = FindKeyIndex(key);
        if (x == null) {
            return -1;
        }
        if (x < 0) {
            return Math.abs(x);
        }
        if (Tree[Math.abs(x)] == null) {
            Tree[x] = key;
            return Math.abs(x);
        }
        return Math.abs(x);
        // индекс добавленного/существующего ключа или -1 если не удалось
    }

}


