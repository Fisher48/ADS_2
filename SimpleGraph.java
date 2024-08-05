import java.util.*;

class Vertex {
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
    }

    @Override
    public String toString() {
        return Value + "";
    }
}

class SimpleGraph {
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size; // максимальное количество вершин
        m_adjacency = new int [size][size]; // матрица смежности
        vertex = new Vertex[size]; // список vertex, хранящий вершины
    }

    public void AddVertex(int value) {
        // ваш код добавления новой вершины
        // со значением value
        // в незанятую позицию vertex
        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i] == null) {
                vertex[i] = new Vertex(value);
                break;
            }
        }
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке vertex
    public void RemoveVertex(int v) {
        // ваш код удаления вершины со всеми её рёбрами
        vertex[v] = null;
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[v][i] = 0;
            m_adjacency[i][v] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) {
        // true если есть ребро между вершинами v1 и v2
        return m_adjacency[v1][v2] == 1;
    }

    public void AddEdge(int v1, int v2) {
        // добавление ребра между вершинами v1 и v2
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        // удаление ребра между вершинами v1 и v2
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов - путь из VFrom в VTo.
        // Список пустой, если пути нет.
        ArrayList<Vertex> path = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < max_vertex; i++) {
            vertex[i].Hit = false;
        }
        stack.push(VFrom);
        while (!stack.empty()) {
            int ver = stack.peek();
            vertex[ver].Hit = true;
            if (VTo == ver) {
                for (int x : stack) {
                    path.add(vertex[x]);
                }
                return path;
            }
            boolean found = false;
            for (int j = 0; j < max_vertex; j++) {
                if (m_adjacency[ver][j] == 1 && !vertex[j].Hit) {
                    found = true;
                    vertex[j].Hit = true;
                    stack.push(j);
                    break;
                }
            }
            if (!found) {
                stack.pop();
            }
        }
        return path;
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов - путь из VFrom в VTo.
        // Список пустой, если пути нет.
        ArrayList<Vertex> path = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] prevVert = new int[max_vertex];
        for (int i = 0; i < max_vertex; i++) {
            vertex[i].Hit = false;
            prevVert[i] = -1;
        }
        vertex[VFrom].Hit = true;
        queue.add(VFrom);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == VTo) {
                while (current != -1) {
                    path.addFirst(vertex[current]);
                    current = prevVert[current];
                }
                return path;
            }
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[i][current] == 1 && !vertex[i].Hit) {
                    vertex[i].Hit = true;
                    prevVert[i] = current;
                    queue.add(i);
                }
            }
        }
        return path;
    }

    public ArrayList<Vertex> WeakVertices() {
        // возвращает список узлов вне треугольников
        ArrayList<Vertex> weekVertList = new ArrayList<>();
        int[] triangles = new int[max_vertex];
        for (int i = 0; i < max_vertex; i++) {
                for (int j = i + 1; j < max_vertex; j++) {
                    if (m_adjacency[i][j] == 1) {
                    for (int k = j + 1; k < max_vertex; k++) {
                        if (m_adjacency[i][k] == 1 && m_adjacency[j][k] == 1) {
                            triangles[i]++;
                            triangles[j]++;
                            triangles[k]++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < max_vertex; i++) {
            if (triangles[i] == 0 && vertex[i] != null) {
                weekVertList.add(vertex[i]);
            }
        }
        return weekVertList;
    }
}


