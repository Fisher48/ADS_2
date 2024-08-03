import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class SimpleGraphTest {

    @Test
    public void SampleTest(){
        SimpleGraph graph = new SimpleGraph(7);
        System.out.println("Список вершин после создания графа: ");
        for (int i = 0; i < graph.max_vertex; i++) {
            System.out.print(graph.vertex[i] + " ");
        }
        System.out.println();
        System.out.println();
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddVertex(7);
        System.out.println("Добавляем 7 вершин: ");
        for (int i = 0; i < graph.max_vertex; i++) {
            System.out.print(graph.vertex[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Состояние графа до создания связей: ");
        for (int i = 0; i < graph.max_vertex; i++) {
            for (int j = 0; j < graph.m_adjacency.length; j++) {
                System.out.print(graph.m_adjacency[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        graph.AddEdge(0, 0);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 0);
        graph.AddEdge(2, 1);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 0);
        graph.AddEdge(3, 1);
        graph.AddEdge(4, 1);
        graph.AddEdge(4, 2);
        graph.AddEdge(1, 5);
        graph.AddEdge(4, 5);
        graph.AddEdge(5, 6);
        System.out.println("Состояние графа после создания связей: ");
        for (int i = 0; i < graph.max_vertex; i++) {
            for (int j = 0; j < graph.m_adjacency.length; j++) {
                System.out.print(graph.m_adjacency[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        graph.RemoveEdge(1, 2);
        System.out.println("Состояние графа после удаления ребра между вершинами 1 и 2: ");
        for (int i = 0; i < graph.max_vertex; i++) {
            for (int j = 0; j < graph.m_adjacency.length; j++) {
                System.out.print(graph.m_adjacency[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Список вершин после удаления 0-й вершины: ");
        graph.RemoveVertex(0);
        for (int i = 0; i < graph.max_vertex; i++) {
            System.out.print(graph.vertex[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Состояние графа после удаления 0-й вершины: ");
        for (int i = 0; i < graph.max_vertex; i++) {
            for (int j = 0; j < graph.m_adjacency.length; j++) {
                System.out.print(graph.m_adjacency[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Между вершинами 2 и 3 есть ребро: " + graph.IsEdge(2, 3));
        System.out.println();
        System.out.println("Между вершинами 4 и 2 есть ребро: " + graph.IsEdge(4, 2));
        System.out.println();
        System.out.println("Список вершин сейчас: ");
        for (int i = 0; i < graph.max_vertex; i++) {
            System.out.print(graph.vertex[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Добавим вершину со значением 8: ");
        graph.AddVertex(8);
        for (int i = 0; i < graph.max_vertex; i++) {
            System.out.print(graph.vertex[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Состояние графа после добавления вершины: ");
        for (int i = 0; i < graph.max_vertex; i++) {
            for (int j = 0; j < graph.m_adjacency.length; j++) {
                System.out.print(graph.m_adjacency[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        graph.AddEdge(0, 0);
        graph.AddEdge(0, 3);
        System.out.println("Состояние графа после добавления пары ребер 0-й вершине: ");
        for (int i = 0; i < graph.max_vertex; i++) {
            for (int j = 0; j < graph.m_adjacency.length; j++) {
                System.out.print(graph.m_adjacency[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Между вершинами 0 и 3 есть ребро: " + graph.IsEdge(0, 3));
    }

    @Test
    public void DeepFirstSearchAndBreadthFirstSearchTest(){
        SimpleGraph graph = new SimpleGraph(6);
        graph.AddVertex(1); graph.AddVertex(2); graph.AddVertex(3);
        graph.AddVertex(4); graph.AddVertex(5); graph.AddVertex(6);
        graph.AddEdge(0,0); graph.AddEdge(2,1); graph.AddEdge(3,2); graph.AddEdge(4,4);
        graph.AddEdge(5,1); graph.AddEdge(5,5); graph.AddEdge(2,0); graph.AddEdge(1,1);
        for (int i = 0; i < graph.max_vertex; i++) {
            for (int j = 0; j < graph.m_adjacency.length; j++) {
                System.out.print(graph.m_adjacency[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(graph.DepthFirstSearch(0,3));
        System.out.println(graph.BreadthFirstSearch(0,3));
    }

}