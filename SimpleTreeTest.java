import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class SimpleTreeTest {

    @Test
    public void SampleTest() {
        SimpleTreeNode<Object> nodeOne = new SimpleTreeNode<>(5,null);
        SimpleTreeNode<Object> nodeTwo = new SimpleTreeNode<>(2, null);
        SimpleTreeNode<Object> nodeThee = new SimpleTreeNode<>(1, null);
        SimpleTreeNode<Object> nodeFour = new SimpleTreeNode<>(10, null);
        SimpleTreeNode<Object> nodeFive = new SimpleTreeNode<>(3, null);
        SimpleTreeNode<Object> nodeSix = new SimpleTreeNode<>(6, null);

        // Проверка добавления узлов
        System.out.println("Проверка добавления узлов:");
        SimpleTree<Object> tree = new SimpleTree<>(nodeOne);
        tree.AddChild(nodeOne,nodeTwo);
        tree.AddChild(nodeTwo,nodeThee);
        tree.AddChild(nodeThee,nodeFour);
        System.out.println(tree.GetAllNodes().toString());
        tree.AddChild(nodeThee,nodeFive);
        tree.AddChild(nodeFour,nodeFive);
        tree.AddChild(nodeFive,nodeSix);
        System.out.println(tree.GetAllNodes().toString());

        // Проверка нахождения узла
        System.out.println("\nПроверка нахождения узла по значению:");
        ArrayList<SimpleTreeNode<Object>> list = new ArrayList<>();
        list.add(nodeOne);
        assertEquals(list,tree.FindNodesByValue(5));
        System.out.println("Ищем " + tree.FindNodesByValue(5) + " и находим " + Arrays.toString(list.toArray()));

        System.out.println("\nДо удаления узла:");
        System.out.println(tree.GetAllNodes().toString());

        // Проверка удаления узла
        System.out.println("\nПосле удаления:");
        tree.DeleteNode(nodeFive);
        System.out.println(tree.GetAllNodes().toString());

        System.out.println("\nОбход дерева:");
        // Последовательно обойти дерево
        for (SimpleTreeNode<Object> node : tree.GetAllNodes()){
            System.out.print(node + " ");
        }
        System.out.println();

        // Проверка кол-во узлов и листьев
        assertEquals(6,tree.Count());
        assertEquals(2,tree.LeafCount());

        System.out.println("\nПосле перемещения:");
        // Проверка перемещения узла на другое место вместе с поддеревом
        tree.MoveNode(nodeFour, nodeTwo);
        System.out.println(tree.GetAllNodes().toString());


        // Проверка кол-во узлов и листьев
        System.out.println("\nКол-во узлов Before " + tree.Count() + "\nи листьев Before: " + tree.LeafCount());
        assertEquals(6,tree.Count());
        assertEquals(2,tree.LeafCount());
        System.out.println(tree.GetAllNodes().toString());

        SimpleTreeNode<Object> nodeSeven= new SimpleTreeNode<>(100,nodeTwo);
        SimpleTreeNode<Object> nodeEight = new SimpleTreeNode<>(999, nodeThee);
        SimpleTreeNode<Object> nodeNine = new SimpleTreeNode<>(111, nodeSeven);
        SimpleTreeNode<Object> nodeTen = new SimpleTreeNode<>(777, nodeEight);
        tree.AddChild(nodeSix,nodeSeven);
        tree.AddChild(nodeFour,nodeNine);
        tree.AddChild(nodeFour,nodeEight);
        tree.AddChild(nodeFour,nodeTen);
        System.out.println("\nКол-во узлов After " + tree.Count() + "\nи листьев After: " + tree.LeafCount());
        assertEquals(10,tree.Count());
        assertEquals(4,tree.LeafCount());
        System.out.println(tree.GetAllNodes().toString());

        System.out.println("\n2 вариант После перемещения:");
        // Проверка перемещения узла на другое место вместе с поддеревом
        tree.MoveNode(nodeFour, nodeNine);
        System.out.println(tree.GetAllNodes().toString());

        // Уровни дерева
        System.out.println("\nПроставляем уровни в дереве:");
        tree.setLevelOnTree(tree.Root,0);
        for (SimpleTreeNode<Object> node : tree.GetAllNodes()) {
            System.out.print(node.nodeLevel + " ");
        }

    }

    @Test
    public void ForestEvenTreesTest(){
        SimpleTree<Object> st = new SimpleTree<>(null);
        SimpleTreeNode<Object> root = new SimpleTreeNode<>(1,null);
        st.Root = root;
        SimpleTreeNode<Object> node2 = new SimpleTreeNode<>(2,root);
        SimpleTreeNode<Object> node3 = new SimpleTreeNode<>(3,null);
        SimpleTreeNode<Object> node4 = new SimpleTreeNode<>(4,null);
        SimpleTreeNode<Object> node5 = new SimpleTreeNode<>(5,null);
        SimpleTreeNode<Object> node6 = new SimpleTreeNode<>(6,null);
        SimpleTreeNode<Object> node7 = new SimpleTreeNode<>(7,null);
        SimpleTreeNode<Object> node8 = new SimpleTreeNode<>(8,null);
        SimpleTreeNode<Object> node9 = new SimpleTreeNode<>(9,null);
        SimpleTreeNode<Object> node10 = new SimpleTreeNode<>(10,null);
        SimpleTreeNode<Object> node11 = new SimpleTreeNode<>(11,null);
        SimpleTreeNode<Object> node12 = new SimpleTreeNode<>(12,null);

        st.AddChild(root, node2);
        st.AddChild(root, node6);
        st.AddChild(root, node11);

        st.AddChild(node11, node12);

        st.AddChild(node2, node3);

        st.AddChild(node6, node7);
        st.AddChild(node6, node8);

        st.AddChild(node8, node9);
        st.AddChild(node8, node10);

        st.AddChild(node3, node4);
        st.AddChild(node3, node5);

        System.out.println(st.GetAllNodes().toString());
        st.printTree(st.Root,0);
        st.setLevelOnTree(st.Root,0);
        System.out.println(st.EvenTrees());

    }

}