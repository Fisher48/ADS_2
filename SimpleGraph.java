import java.util.*;

class Vertex {
    public int Value;
    public Vertex(int val) {
        Value = val;
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
        for (int i = 0; i < max_vertex; i++) {
            for (int j = 0; j < m_adjacency.length; j++) {
                if (i == v && j == 1) {
                    vertex[i] = null;
                    m_adjacency[i][j] = 0;
                }
            }
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
}


