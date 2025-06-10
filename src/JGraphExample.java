import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.nio.dot.DOTExporter;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

public class JGraphExample {
    public static void main(String[] args) {
        // Crea un grafo dirigido y ponderado usando DefaultWeightedEdge para las aristas
        Graph<String, DefaultWeightedEdge> peruGraph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        
        // Añadir vértices al grafo, representando destinos.
        peruGraph.addVertex("Lima"); 
        peruGraph.addVertex("Cusco");
        peruGraph.addVertex("Machu Picchu");
        peruGraph.addVertex("Arequipa"); 
        peruGraph.addVertex("Puno");

        // Añade aristas con pesos (distancias en km) entre destinos - Vertices
        DefaultWeightedEdge e1 = peruGraph.addEdge("Lima", "Cusco");
        peruGraph.setEdgeWeight(e1, 1100.0); 
        DefaultWeightedEdge e2 = peruGraph.addEdge("Cusco", "Machu Picchu");
        peruGraph.setEdgeWeight(e2, 110.0); 
        DefaultWeightedEdge e3 = peruGraph.addEdge("Lima", "Arequipa");
        peruGraph.setEdgeWeight(e3, 1000.0);
        DefaultWeightedEdge e4 = peruGraph.addEdge("Arequipa", "Puno");
        peruGraph.setEdgeWeight(e4, 320.0); 
        DefaultWeightedEdge e5 = peruGraph.addEdge("Cusco", "Puno");
        peruGraph.setEdgeWeight(e5, 390.0); 
        DefaultWeightedEdge e6 = peruGraph.addEdge("Puno", "Lima");
        peruGraph.setEdgeWeight(e6, 1300.0);
        
        // Número total de vértices en el grafo
        System.out.println("Número de destinos(Vertices): " + peruGraph.vertexSet().size());
        // Número total de aristas (rutas) en el grafo
        System.out.println("Número de rutas: " + peruGraph.edgeSet().size());
        // Grado del vértice "Cusco" (número de aristas conectadas)
        System.out.println("Conexiones desde Cusco: " + peruGraph.degreeOf("Cusco"));
        
        // Crea un inspector para analizar la conectividad del grafo
        ConnectivityInspector<String, DefaultWeightedEdge> inspector = new ConnectivityInspector<>(peruGraph);
        System.out.println("\n¿Es conexo? " + inspector.isConnected());
        System.out.println("Componentes conexas: " + inspector.connectedSets());
        
        // Realiza un recorrido en amplitud (BFS) desde el vertice "Lima"
        System.out.println("\nRecorrido BFS desde Lima:");
        Iterator<String> bfsIterator = new BreadthFirstIterator<>(peruGraph, "Lima");
        // Itera e imprime los vértices en orden BFS
        while (bfsIterator.hasNext()) {
            System.out.print(bfsIterator.next() + " ");
        }
        
        // Realiza un recorrido en profundidad (DFS) empezando desde el vertice "Cusco"
        System.out.println("\n\nRecorrido DFS desde Cusco:");
        Iterator<String> dfsIterator = new DepthFirstIterator<>(peruGraph, "Cusco");
        // Itera e imprime los vértices en orden DFS
        while (dfsIterator.hasNext()) {
            System.out.print(dfsIterator.next() + " ");
        }
        
    }
}