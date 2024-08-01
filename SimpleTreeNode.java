import java.util.*;

public class SimpleTreeNode<T>
{
    public int nodeLevel;
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }

    @Override
    public String toString() {
        return NodeValue + "";
    }
}

class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    public void setLevelOnTree(SimpleTreeNode<T> rootNode, int level) {
        rootNode.nodeLevel = level;
        if (rootNode.Children == null) {
            return;
        }
        for (SimpleTreeNode<T> node : rootNode.Children) {
            setLevelOnTree(node, level + 1);
        }
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        // ваш код добавления нового дочернего узла существующему ParentNode
        if (ParentNode.Children == null) {
            ParentNode.Children = new ArrayList<>();
        }
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        // ваш код удаления существующего узла NodeToDelete
        NodeToDelete.Parent.Children.remove(NodeToDelete);
    }

    public List<SimpleTreeNode<T>> getNodes(SimpleTreeNode<T> rootNode){
        List<SimpleTreeNode<T>> listOfNodes = new ArrayList<>();
        if (rootNode.Children == null) {
            listOfNodes.add(rootNode);
            return listOfNodes;
        }
        listOfNodes.add(rootNode);
        for (SimpleTreeNode<T> node : rootNode.Children) {
            listOfNodes.addAll(getNodes(node));
        }
        return listOfNodes;
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        // ваш код выдачи всех узлов дерева в определённом порядке
        return getNodes(Root);
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        // ваш код поиска узлов по значению
        List<SimpleTreeNode<T>> listOfFoundedNodes = new ArrayList<>();
        for (SimpleTreeNode<T> node : getNodes(Root)) {
            if (node.NodeValue == val) {
                listOfFoundedNodes.add(node);
            }
        }
        return listOfFoundedNodes;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
        DeleteNode(OriginalNode);
        AddChild(NewParent,OriginalNode);
    }

    public int Count()
    {
        // количество всех узлов в дереве
        return getNodes(Root).size();
    }

    public int LeafCount()
    {
        // количество листьев в дереве
        int leafsCount = 0;
        for (SimpleTreeNode<T> node : getNodes(Root)) {
            if (node.Children == null || node.Children.isEmpty()) {
                leafsCount++;
            }
        }
        return leafsCount;
    }

    public void printTree(SimpleTreeNode<T> node, int depth){
        if (node == null) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.print("|");
        for (int j = 0; j < depth; j++) {
            System.out.print("_");
        }
        System.out.println(node.NodeValue);
        if (node.Children != null) {
            for (SimpleTreeNode<T> child : node.Children) {
                printTree(child, depth + 1);
            }
        }
    }

    public ArrayList<T> EvenTrees()
    {
        ArrayList<T> deletedNodes = new ArrayList<>();
        Queue<SimpleTreeNode<T>> queue = new ArrayDeque<>();
        SimpleTreeNode<T> node = Root;
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            SimpleTree<T> tree = new SimpleTree<>(node);
                if (tree.Count() % 2 == 0) {
                    if (node.Parent != null) {
                    deletedNodes.add(node.Parent.NodeValue);
                    deletedNodes.add(node.NodeValue);
                }
                queue.addAll(node.Children);
            }
        }
        return deletedNodes;
    }

}


