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
        
        
    }
}