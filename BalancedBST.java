import java.util.*;

class BSNode
{
    public int NodeKey; // ключ узла
    public BSNode Parent; // родитель или null для корня
    public BSNode LeftChild; // левый потомок
    public BSNode RightChild; // правый потомок
    public int     Level; // глубина узла

    public BSNode(int key, BSNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST
{
    public BSNode Root; // корень дерева

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a){
        // создаём дерево с нуля из неотсортированного массива a
        Arrays.sort(a);
        Root = genBSTArray(a, 0, a.length-1, null, 0);
    }

    public static BSNode genBSTArray(int[] a, int start, int end, BSNode node, int level){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BSNode A = new BSNode(a[mid], node);
        A.Level = level;
        A.LeftChild = genBSTArray(a, start, mid - 1, A, level + 1);
        A.RightChild = genBSTArray(a, mid + 1, end, A, level + 1);
        return A;
    }

    public boolean IsBalanced(BSNode root_node) {
        if (root_node == null) {
            return true;
        }
        return Math.abs(getHeight(root_node.LeftChild) - getHeight(root_node.RightChild)) <= 1; // сбалансировано ли дерево с корнем root_node
    }

    public static int getHeight(BSNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.LeftChild),getHeight(node.RightChild)) + 1;
    }

    public void printTree(BSNode node, int depth) {
        if (node == null) {
            return;
        }
        printTree(node.RightChild, depth + 1);
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(node.NodeKey);
        printTree(node.LeftChild, depth + 1);
    }

}  