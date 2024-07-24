import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

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

        System.out.println("Дерево до удаления узла:");
        System.out.println(tree.Count());
        System.out.println(tree.getAllNodes(tree.Root));

        int delKey = 5;
        tree.DeleteNodeByKey(delKey);
        System.out.println("После удаления узла по ключу " + delKey);
        System.out.println(tree.getAllNodes(tree.Root));
        System.out.println(tree.Count());

        delKey = 100;
        tree.DeleteNodeByKey(delKey);
        System.out.println("После удаления узла по ключу " + delKey);
        System.out.println(tree.getAllNodes(tree.Root));
        System.out.println(tree.Count());

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

}