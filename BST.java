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


    public BSTFind<T> findNode(BSTNode<T> node, int keySearch) {
        BSTFind<T> foundNode = new BSTFind<>();
        if (Root == null || node == null) {
            return foundNode;
        }
        if (node.NodeKey == keySearch) {
            foundNode.Node = node;
            foundNode.NodeHasKey = true;
            return foundNode;
        } else if (keySearch < node.NodeKey) {
            if (node.LeftChild == null) {
                foundNode.Node = node;
                foundNode.ToLeft = true;
                return foundNode;
            }
            foundNode = findNode(node.LeftChild, keySearch);
        } else {
            if (node.RightChild == null) {
                foundNode.Node = node;
                foundNode.ToLeft = false;
                return foundNode;
            }
            foundNode = findNode(node.RightChild, keySearch);
        }
        return foundNode;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        // ищем в дереве узел и сопутствующую информацию по ключу
        return findNode(Root, key);
    }

    public boolean AddKeyValue(int key, T val) {
        // добавляем ключ-значение в дерево
        BSTFind<T> foundNode = FindNodeByKey(key);
        BSTNode<T> newNode = new BSTNode<>(key,val,foundNode.Node);
        if (Root == null) {
            Root = newNode;
            return true;
        }
        if (foundNode.Node == null) {
            Root = newNode;
            return true;
        } else if (foundNode.NodeHasKey) {
            return false;
        } else if (foundNode.ToLeft) {
            foundNode.Node.LeftChild = newNode;
        } else {
            foundNode.Node.RightChild = newNode;
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
                if (Root != null) {
                    Root.Parent = null;
                }
            } else if (current == parent.LeftChild) {
                parent.LeftChild = current.RightChild;
                if (parent.LeftChild != null) {
                    parent.LeftChild.Parent = parent;
                }
            } else {
                parent.RightChild = current.RightChild;
                if (parent.RightChild!= null) {
                    parent.RightChild.Parent = parent;
                }
            }
        } else if (current.RightChild == null) {
            if (parent == null) {
                Root = current.LeftChild;
                Root.Parent = null;
            } else if (current == parent.LeftChild) {
                parent.LeftChild = current.LeftChild;
                parent.LeftChild.Parent = parent;
            } else {
                parent.RightChild = current.LeftChild;
                parent.RightChild.Parent = parent;
            }
        } else {
            BSTNode<T> successor = findSuccessor(current);
            if (parent == null) {
                Root = successor;
                Root.Parent = null;
            } else if (current == parent.LeftChild) {
                parent.LeftChild = successor;
                if (parent.LeftChild != null) {
                    parent.LeftChild.Parent = parent;
                }
            } else {
                parent.RightChild = successor;
                if (parent.RightChild!= null) {
                    parent.RightChild.Parent = parent;
                }
            }
            successor.LeftChild = current.LeftChild;
            if (successor.LeftChild != null) {
                successor.LeftChild.Parent = successor;
            }
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

    public ArrayList<BSTNode> WideAllNodes() {
        ArrayList<BSTNode> list = new ArrayList<>();
        Queue<BSTNode<T>> queue = new LinkedList<>();
        queue.add(Root);
        while (!queue.isEmpty()) {
            BSTNode<T> node = queue.poll();
            list.add(node);
            if (node.LeftChild != null) {
                queue.add(node.LeftChild);
            }
            if (node.RightChild != null) {
                queue.add(node.RightChild);
            }
        }
        return list;
    }

    public void printTree(BSTNode<T> node, int depth) {
        if (node == null) {
            return;
        }
        printTree(node.RightChild, depth + 1);
        for (int i = 0; i < depth; i++) {
            System.out.print("     ");
        }
        System.out.println(node.NodeValue);
        printTree(node.LeftChild, depth + 1);
    }

    public ArrayList<BSTNode> deepAllNodesByOrder(BSTNode<T> node, int order){
        ArrayList<BSTNode> list = new ArrayList<>();
        switch (order) {
            // In-order - первым будет самый маленький (так как мы сперва берём левые),
            // а последним самый большой узел, то есть мы получаем отсортированные ключи.
            case (0):
                if (node.LeftChild != null) {
                    list.addAll(deepAllNodesByOrder(node.LeftChild, order));
                }
                list.add(node);
                if (node.RightChild != null) {
                    list.addAll(deepAllNodesByOrder(node.RightChild, order));
                }
                return list;
            // Post-order первыми выдаст листья, самые нижние узлы (так как корень берём в последнюю очередь), что удобно,
            // если нам нужно проверять первыми именно листья и искать снизу вверх.
            case (1):
                if (node.LeftChild != null) {
                    list.addAll(deepAllNodesByOrder(node.LeftChild, order));
                }
                if (node.RightChild != null) {
                    list.addAll(deepAllNodesByOrder(node.RightChild, order));
                }
                list.add(node);
                return list;
            // Pre-order удобен, если мы хотим искать нужный ключ, начиная с корня, сверху вниз.
            case (2):
                list.add(node);
                if (node.LeftChild != null) {
                    list.addAll(deepAllNodesByOrder(node.LeftChild, order));
                }
                if (node.RightChild != null) {
                    list.addAll(deepAllNodesByOrder(node.RightChild, order));
                }
                return list;
            default:
                throw new IllegalStateException("Unexpected value: " + order);
        }
    }
    public ArrayList<BSTNode> DeepAllNodes(int order){
        return deepAllNodesByOrder(Root, order);
    }

    public void invertTree(BSTNode<T> node){
        if (node == null) {
            return;
        }
        BSTNode<T> temp = node.LeftChild;
        node.LeftChild = node.RightChild;
        node.RightChild = temp;
        invertTree(node.LeftChild);
        invertTree(node.RightChild);
    }

}


