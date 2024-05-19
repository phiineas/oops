package questions.dccn;

import java.util.*;

public class practical1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the number of nodes in the graph:");
        int numNodes = sc.nextInt();
    
        int[][] graph = new int[numNodes][numNodes];
    
        System.out.println("Enter the adjacency matrix for the graph (" + numNodes + "x" + numNodes + " matrix):");
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
    
        System.out.println("Enter the source node:");
        int source = sc.nextInt();
    
        System.out.println("Enter the destination node:");
        int destination = sc.nextInt();
    
        sc.close();
        int[] prev = new int[numNodes];
        Arrays.fill(prev, -1);  // Initialize prev array with -1
        int[] distances = dijkstra(graph, source, prev);
    
        System.out.println("Shortest distance from node " + source + " to node " + destination + ": " + distances[destination] + " \nPath: ");
        printPath(prev, destination);
        System.out.println();
    
        // int totalCost = totalCost(graph);
        // System.out.println("The total cost of traversing the graph is: " + totalCost);
    }
    
    private static final int INFINITY = Integer.MAX_VALUE;

    // Add a new parameter for the prev array

    public static int[] dijkstra(int[][] graph, int source, int[] prev) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        // Initialize distances to infinity and visited array to false
        for (int i = 0; i < numNodes; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        // Distance from source to itself is 0
        distances[source] = 0;

        // Find shortest path for all nodes
        for (int i = 0; i < numNodes - 1; i++) {
            // Pick the minimum distance node from the set of nodes not yet processed
            int u = minDistance(distances, visited);

            // Mark the picked node as processed
            visited[u] = true;

            // Update distance value of the adjacent nodes of the picked node
            for (int v = 0; v < numNodes; v++) {
                if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                    prev[v] = u;  // Save the previous node
                }
            }
        }

        return distances;
    }

    // Function to find the vertex with minimum distance value
    private static int minDistance(int[] distance, boolean[] visited) {
        int min = INFINITY;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void printPath(int[] prev, int target) {
        if (prev[target] == -1) {  
            System.out.print(target);
            return;
        }
    
        printPath(prev, prev[target]);  
        System.out.print("-" + target);  
    }

    // public static int totalCost(int[][] graph) {
    //     int totalCost = 0;
    //     for (int i = 0; i < graph.length; i++) {
    //         for (int j = 0; j < graph[i].length; j++) {
    //             totalCost += graph[i][j];
    //         }
    //     }
    //     return totalCost;
    // }
}
