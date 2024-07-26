import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

    private Random rand = new Random();

    @Test
    public void SampleTest(){
        BST<Object> tree = new BST<>(null);
        tree.AddKeyValue(17,17);
        tree.AddKeyValue(234,234);
        tree.AddKeyValue(15,15);
        tree.AddKeyValue(5,5);
        tree.AddKeyValue(1,1);
        tree.AddKeyValue(11,11);
        BSTNode<Object> nodeOne = new BSTNode<>(100,100,null);
        BSTNode<Object> nodeTwo = new BSTNode<>(30,30,null);
        BSTNode<Object> nodeThree = new BSTNode<>(300,300,null);
        BSTNode<Object> nodeFour = new BSTNode<>(50,50,null);
        BSTNode<Object> nodeFive = new BSTNode<>(111,111,null);
        System.out.println(tree.getAllNodes(tree.Root));
        System.out.println("Кол-во узлов:");
        System.out.println(tree.Count());
        tree.AddKeyValue(nodeOne.NodeKey,nodeOne.NodeValue);
        tree.AddKeyValue(nodeTwo.NodeKey,nodeTwo.NodeValue);
        tree.AddKeyValue(nodeThree.NodeKey,nodeThree.NodeValue);
        tree.AddKeyValue(nodeFour.NodeKey,nodeFour.NodeValue);
        tree.AddKeyValue(nodeFive.NodeKey,nodeFive.NodeValue);


        System.out.println(tree.getAllNodes(tree.Root));
        System.out.println("Кол-во узлов:");
        System.out.println(tree.Count());
        tree.FindNodeByKey(15);

        System.out.println("Поиск минимального из корня:");
        System.out.println(tree.FinMinMax(tree.Root,false));
        System.out.println("Поиск максимального из корня:");
        System.out.println(tree.FinMinMax(tree.Root,true));
        System.out.println("Поиск минимального из nodeOne:");
        System.out.println(tree.FinMinMax(nodeOne,false));
        System.out.println("Поиск максимального из nodeTwo:");
        System.out.println(tree.FinMinMax(nodeTwo,true));

        System.out.println("Кол-во узлов и структура дерева до: " + tree.Count());
        System.out.println(tree.getAllNodes(tree.Root));

        int delKey = 5;
        tree.DeleteNodeByKey(delKey);
        System.out.println("\nПосле удаления узла по ключу " + delKey);
        System.out.println("Кол-во узлов и структура дерева до: " + tree.Count());
        System.out.println(tree.getAllNodes(tree.Root));

        delKey = 100;
        tree.DeleteNodeByKey(delKey);
        System.out.println("\nПосле удаления узла по ключу " + delKey);
        System.out.println("Кол-во узлов и структура дерева до: " + tree.Count());
        System.out.println(tree.getAllNodes(tree.Root));

    }

    @Test
    public void SearchKeyTest(){
        BST<Integer> tree = new BST<>(null);

        // Поиск не существующего ключа
        BSTFind<Integer> findResult = tree.FindNodeByKey(5);
        System.out.println("Поиск не существующего ключа 5: " + findResult.NodeHasKey);
        System.out.println("Направление: " + findResult.ToLeft);

        // Добавили узел с ключом 5 к левому потомку
        tree.AddKeyValue(5, 5);
        findResult = tree.FindNodeByKey(5);
        System.out.println("Поиск существующего ключа 5: " + findResult.NodeHasKey);
        System.out.println(tree.getAllNodes(tree.Root).toString());
        // Поиск не существующего ключа
        findResult = tree.FindNodeByKey(10);
        System.out.println("Поиск не существующего ключа 10: " + findResult.NodeHasKey);
        System.out.println("Направление: " + findResult.ToLeft);

        // Добавили узел с ключом 10 в правому потомку
        tree.AddKeyValue(10, 10);

        findResult = tree.FindNodeByKey(10);
        System.out.println("Поиск существующего ключа 10: " + findResult.NodeHasKey);
        System.out.println(tree.getAllNodes(tree.Root).toString());

        tree.AddKeyValue(100,100);
        findResult = tree.FindNodeByKey(100);
        System.out.println("Поиск существующего ключа 100: " + findResult.NodeHasKey);
        System.out.println("Направление: " + findResult.ToLeft);

        System.out.println("Удаление ключа 100:");
        tree.DeleteNodeByKey(100);
        System.out.println(tree.getAllNodes(tree.Root).toString());

        BSTFind<Integer> emptyNode = tree.FindNodeByKey(99);
        System.out.println("Поиск несуществующего ключа: " + emptyNode.Node.NodeKey);
        System.out.println(emptyNode.NodeHasKey);
        System.out.println("Поиск существующего ключа: " + findResult.Node.NodeKey);
        System.out.println(findResult.NodeHasKey);


    }

    @Test
    public void wideAllTest(){
        BST tree = new BST<>(null);
        for (int i = 0; i < 10; i++) {
            int x = rand.nextInt(100) + 1;
            tree.AddKeyValue(x, x);
        }
        tree.printTree(tree.Root,0);
        System.out.println("Обход дерева в ширину:");
        System.out.println(tree.WideAllNodes());
    }

    @Test
    public void deepAllOrdersTest(){
        BST tree = new BST<>(null);
//        for (int i = 0; i < 10; i++) {
//            int x = rand.nextInt(100) + 1;
//            tree.AddKeyValue(x, x);
//        }
        tree.AddKeyValue(5,5); tree.AddKeyValue(6,6); tree.AddKeyValue(2,2); tree.AddKeyValue(10,10);
        tree.AddKeyValue(11,11); tree.AddKeyValue(1,1); tree.AddKeyValue(8,8); tree.AddKeyValue(4,4);
        tree.AddKeyValue(7,7); tree.AddKeyValue(12,12); tree.AddKeyValue(9,9); tree.AddKeyValue(3,3);
        System.out.println("Дерево изначальное:");
        tree.printTree(tree.Root,0);
        System.out.println("\nIn-order test:");
        System.out.println(tree.DeepAllNodes(0));
        System.out.println("\nPost-order test:");
        System.out.println(tree.DeepAllNodes(1));
        System.out.println("\nPre-order test:");
        System.out.println(tree.DeepAllNodes(2));
        System.out.println("\nИнвертированное дерево:");
        tree.invertTree(tree.Root);
        tree.printTree(tree.Root,0);

    }

//    @Test
//    public void sTest(){
//
//        BSTNode<Integer> nodeEight = new BSTNode<Integer>(8, 8, null);
//        BSTNode<Integer> nodeFour = new BSTNode<Integer>(4, 4, nodeEight);
//        BSTNode<Integer> nodeTwelve = new BSTNode<Integer>(12, 12, nodeEight);
//        nodeEight.LeftChild = nodeFour;
//        nodeEight.RightChild = nodeTwelve;
//        BSTNode<Integer> nodeTwo = new BSTNode<Integer>(2, 2, nodeFour);
//        BSTNode<Integer> nodeSix = new BSTNode<Integer>(6, 6, nodeFour);
//        BSTNode<Integer> nodeTen = new BSTNode<Integer>(10, 10, nodeTwelve);
//        BSTNode<Integer> nodeFourteen = new BSTNode<Integer>(14, 14, nodeTwelve);
//        nodeFour.LeftChild = nodeTwo;
//        nodeFour.RightChild = nodeSix;
//        nodeTwelve.LeftChild = nodeTen;
//        nodeTwelve.RightChild = nodeFourteen;
//
//        BST<Integer> bst = new BST<Integer>(nodeEight);
//
//        BST<Integer> emptybst = new BST<Integer>(new BSTNode<Integer>(0, 0, null));
//
//       System.out.println("Тест удаления по ключу 0: ");
//        for (BSTNode<Integer> i : emptybst.getAllNodes(emptybst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + emptybst.Count());
//        emptybst.DeleteNodeByKey(0);
//        if (emptybst.Root != null)
//        for (BSTNode<Integer> i : emptybst.getAllNodes(emptybst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + emptybst.Count());
//
//        System.out.println();
//
//
//        System.out.println("Тест добавления ключа в пустое дерево: ");
//        if (emptybst.Root != null)
//        for (BSTNode<Integer> i : bst.getAllNodes(emptybst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println("Количество элементов: " + emptybst.Count());
//        System.out.println("Добавляем узел с ключом 88: ");
//        emptybst.AddKeyValue(88, 88);
//        for (BSTNode<Integer> i : emptybst.getAllNodes(emptybst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + emptybst.Count());
//        emptybst.DeleteNodeByKey(88);
//        System.out.println();
//        System.out.println();
//
//
//
//        System.out.println("Тест поиска имеющегося ключа: ");
//        BSTFind<Integer> foundNode = bst.FindNodeByKey(8);
//        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node);
//        System.out.println("Тест поиска ключа который должен быть добавлен справа: ");
//        foundNode = bst.FindNodeByKey(7);
//        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node + ", Слева:" + foundNode.ToLeft);
//        System.out.println("Тест поиска ключа который должен быть добавлен слева: ");
//        foundNode = bst.FindNodeByKey(5);
//        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node + ", Слева:" + foundNode.ToLeft);
//
//
//
//        System.out.println();
//        System.out.println();
//
//
//
//        System.out.println("Тест добавления имеющегося ключа: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println("Значение узла с ключом 6 - " + bst.FindNodeByKey(6).Node.NodeValue);
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println("Добавляем узел с ключом 6 и значением 0: ");
//        bst.AddKeyValue(6, 0);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println("Значение узла с ключом 6 - " + bst.FindNodeByKey(6).Node.NodeValue);
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//        System.out.println("Тест добавления левого ключа: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println("Добавляем узел с ключом 5: ");
//        bst.AddKeyValue(5, 0);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//        System.out.println("Тест добавления правого ключа: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println("Добавляем узел с ключом 7: ");
//        bst.AddKeyValue(7, 0);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//
//        System.out.println();
//
//
//        System.out.println("Тест с поиском максимального ключа с корня: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println(bst.FinMinMax(bst.Root, true));
//
//        System.out.println("Тест с поиском минимального ключа с корня: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println(bst.FinMinMax(bst.Root, false));
//
//        System.out.println("Тест с поиском максимального ключа с узла 4: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println(bst.FinMinMax(nodeFour, true));
//
//        System.out.println("Тест с поиском минимального ключа с узла 12: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println(bst.FinMinMax(nodeTwelve, false));
//
//
//        System.out.println();
//        System.out.println();
//
//
//        System.out.println("Тест поиска ключа 8: ");
//        foundNode = bst.FindNodeByKey(8);
//        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node+ ", Слева:" + foundNode.ToLeft);
//        System.out.println("Тест поиска удалённого ключа: ");
//        foundNode = bst.FindNodeByKey(6);
//        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node + ", Слева:" + foundNode.ToLeft);
//        System.out.println("Тест поиска удалённого ключа: ");
//        foundNode = bst.FindNodeByKey(7);
//        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node + ", Слева:" + foundNode.ToLeft);
//
//
//
//        System.out.println();
//        System.out.println();
//
//
//
//        System.out.println("Тест удаления по несуществующему ключу: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Удаляем по ключу 23: ");
//        bst.DeleteNodeByKey(23);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//
//        System.out.println("Тест удаления по ключу 6: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        bst.DeleteNodeByKey(6);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//        System.out.println("Тест удаления по ключу 7: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        bst.DeleteNodeByKey(7);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//
//        System.out.println("Количество элементов: " + bst.Count());
//
//        System.out.println();
//
//        System.out.println("Тест удаления по ключу 4: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        bst.DeleteNodeByKey(4);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//        System.out.println();
//
//        System.out.println("Тест удаления по ключу 8: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        bst.DeleteNodeByKey(8);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//        System.out.println();
//
//        System.out.println("Тест удаления по ключу 14: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        bst.DeleteNodeByKey(14);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//
//        System.out.println();
//
//        System.out.println("Тест удаления по ключу 12: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        bst.DeleteNodeByKey(12);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//        System.out.println();
//
//        System.out.println("Тест удаления по ключу 10: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        bst.DeleteNodeByKey(10);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//        System.out.println("Тест удаления по ключу 5: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        bst.DeleteNodeByKey(5);
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//        System.out.println("Тест удаления по ключу 2: ");
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        bst.DeleteNodeByKey(2);
//        if (bst.Root != null)
//        for (BSTNode<Integer> i : bst.getAllNodes(bst.Root))
//        {
//            System.out.print(i);
//        }
//        System.out.println();
//        System.out.println("Количество элементов: " + bst.Count());
//        System.out.println();
//
//    }
}