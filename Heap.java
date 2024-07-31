import java.util.*;

class Heap
{
    public int [] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() { HeapArray = null; }

    public void MakeHeap(int[] a, int depth) {
        // создаём массив кучи HeapArray из заданного
        // размер массива выбираем на основе глубины depth
        int size = (int) Math.pow(2, depth + 1) - 1;
        HeapArray = new int[size];
        HeapArray = Arrays.copyOf(a, HeapArray.length);
        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public void swap(int i, int j){
        int temp = HeapArray[i];
        HeapArray[i] = HeapArray[j];
        HeapArray[j] = temp;
    }

    public void siftDown(int ind){
        int largest = ind;
        int left = ind * 2 + 1;
        int right = ind * 2 + 2;
        if (left < HeapArray.length && HeapArray[left] > HeapArray[largest]) {
            largest = left;
        }
        if (right < HeapArray.length && HeapArray[right] > HeapArray[largest]) {
            largest = right;
        }
        if (largest != ind) {
           swap(ind, largest);
           siftDown(largest);
        }
    }

    public int GetMax() {
        // вернуть значение корня и перестроить кучу
        if (HeapArray.length == 0) {
            return -1; // если куча пуста
        }
        int max = HeapArray[0];
        HeapArray[0] = HeapArray[HeapArray.length-1];
        HeapArray = Arrays.copyOf(HeapArray, HeapArray.length-1);
        siftDown(0);
        return max;
    }

    public void siftUp(int ind) {
        int parent = (ind - 1) / 2;
        if (parent >= 0 && HeapArray[parent] < HeapArray[ind]) {
            swap(parent, ind);
            siftUp(parent);
        }
    }

    public boolean Add(int key) {
        // добавляем новый элемент key в кучу и перестраиваем её
        if (HeapArray == null) {
            return false; // если куча вся заполнена
        }
        int[] newArray = Arrays.copyOf(HeapArray, HeapArray.length + 1);
        newArray[newArray.length - 1] = key; // добавляем элемент в конец массива
        HeapArray = newArray;
        int index = HeapArray.length - 1;
        int parentIndex = (index - 1) / 2;
        while (index > 0 && HeapArray[parentIndex] < HeapArray[index]) {
            siftUp(index);
        }
        return true;
    }

}


