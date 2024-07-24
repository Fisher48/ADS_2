import java.io.*;
import java.util.*;


class BSTNode<T> {
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }

    @Override
    public String toString() {
        return NodeValue + "";
    }
}

// промежуточный результат поиска
class BSTFind<T> {
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T> {
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node) {
        Root = node;
    }

    public List<BSTNode<T>> getAllNodes(BSTNode<T> node) {
        List<BSTNode<T>> allNodes = new ArrayList<>();
        if (node != null) {
            allNodes.add(node);
            allNodes.addAll(getAllNodes(node.LeftChild));
            allNodes.addAll(getAllNodes(node.RightChild));
        }
        return allNodes;
    }

    public BSTFind<T> findNode(BSTNode<T> searchingNode, int key) {
        BSTFind<T> foundedNode = new BSTFind<>();
        if (Root == null) {
            return null;
        }
        if (key == searchingNode.NodeKey) {
            foundedNode.Node = Root;
            foundedNode.NodeHasKey = true;
            return foundedNode;
        } else if (key < searchingNode.NodeKey) {
            if (searchingNode.LeftChild == null) {
                foundedNode.Node = searchingNode;
                foundedNode.ToLeft = true;
                return foundedNode;
            }
            foundedNode = findNode(searchingNode.LeftChild, key);
        } else {
            if (searchingNode.RightChild == null) {
                foundedNode.Node = searchingNode;
                return foundedNode;
            }
            foundedNode = findNode(searchingNode.RightChild, key);
        }
        return foundedNode;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        // ищем в дереве узел и сопутствующую информацию по ключу
        if (Root == null) {
            return new BSTFind<>();
        }
        return findNode(Root, key);
    }

    public boolean AddKeyValue(int key, T val) {
        // добавляем ключ-значение в дерево
        BSTFind<T> foundedNode = findNode(Root, key);
        if (foundedNode == null) {
            Root = new BSTNode<>(key, val, null);
            return true;
        }
        if (foundedNode.Node == null) {
            Root = new BSTNode<>(key, val, null);
        } else if (foundedNode.NodeHasKey) {
            return false; // если ключ уже есть
        }
        if (foundedNode.ToLeft) {
            foundedNode.Node.LeftChild = new BSTNode<>(key, val, foundedNode.Node);
        } else {
            foundedNode.Node.RightChild = new BSTNode<>(key, val, foundedNode.Node);
        }
        return true;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        // ищем максимальный/минимальный ключ в поддереве
        BSTNode<T> node = FromNode;
        if (FindMax) {
            while (node.RightChild != null) {
                node = node.RightChild;
            }
        }
        else {
            while (node.LeftChild != null) {
                node = node.LeftChild;
            }
        }
        return node;
    }

    public boolean DeleteNodeByKey(int key) {
        BSTNode<T> parent = null;
        BSTNode<T> current = Root;
        // Поиск узла с заданным ключом
        while (current != null) {
            if (key == current.NodeKey) {
                break;
            }
            parent = current;
            if (key < current.NodeKey) {
                current = current.LeftChild;
            } else {
                current = current.RightChild;
            }
        }
        // Если узел с заданным ключом не найден
        if (current == null) {
            return false;
        }
        // Удаление найденного узла из дерева
        if (current.LeftChild == null) {
            if (parent == null) {
                Root = current.RightChild;
            } else if (current == parent.LeftChild) {
                parent.LeftChild = current.RightChild;
            } else {
                parent.RightChild = current.RightChild;
            }
        } else if (current.RightChild == null) {
            if (parent == null) {
                Root = current.LeftChild;
            } else if (current == parent.LeftChild) {
                parent.LeftChild = current.LeftChild;
            } else {
                parent.RightChild = current.LeftChild;
            }
        } else {
            BSTNode<T> successor = findSuccessor(current);
            if (parent == null) {
                Root = successor;
            } else if (current == parent.LeftChild) {
                parent.LeftChild = successor;
            } else {
                parent.RightChild = successor;
            }
            successor.LeftChild = current.LeftChild;
        }
        return true;
    }

    private BSTNode<T> findSuccessor(BSTNode<T> node) {
        BSTNode<T> parent = node;
        BSTNode<T> successor = node;
        BSTNode<T> current = node.RightChild;
        while (current != null) {
            parent = successor;
            successor = current;
            current = current.LeftChild;
        }
        if (successor != node.RightChild) {
            parent.LeftChild = successor.RightChild;
            successor.RightChild = node.RightChild;
        }
        return successor;
    }

    public int Count() {
        return getAllNodes(Root).size(); // количество узлов в дереве
    }

}


