import java.util.*;

class BSTNode
{
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int     Level; // глубина узла

    public BSTNode(int key, BSTNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST
{
    public BSTNode Root; // корень дерева

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a){
        // создаём дерево с нуля из неотсортированного массива a
        Arrays.sort(a);
        Root = genBSTArray(a, 0, a.length-1, Root, 0);
    }

    public static BSTNode genBSTArray(int[] a, int start, int end, BSTNode root, int level){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BSTNode node = new BSTNode(a[mid], root);
        node.Level = level;
        node.LeftChild = genBSTArray(a, start, mid - 1, node, level + 1);
        node.RightChild = genBSTArray(a, mid + 1, end, node, level + 1);
        return node;
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node == null) {
            return true;
        }
        return Math.abs(getHeight(root_node.LeftChild) - getHeight(root_node.RightChild)) <= 1; // сбалансировано ли дерево с корнем root_node
    }

    public static int getHeight(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.LeftChild),getHeight(node.RightChild)) + 1;
    }

    public void printTree(BSTNode node, int depth) {
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