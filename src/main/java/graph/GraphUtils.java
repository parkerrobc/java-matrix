package graph;

import java.util.ArrayList;

/**
 * Utilities for graphs
 *
 * @author parkerrobc
 */
public final class GraphUtils {

    private GraphUtils() {

    }

    /***
     * Creates {@code ArrayList<Point>} used for graph based algorithms.
     * Converts a {@code n} by {@code 2} {@code double[][]}
     *
     * @param rawGraph {@code double[][] rawGraph} representing a graph
     *
     * @return {@code ArrayList<Point>}
     */
    public  static ArrayList<Point> createPointArray(final double[][] rawGraph) {
        ArrayList<Point> graph = new ArrayList<Point>();

        for (double[] rawPoint: rawGraph) {
            Point point = new Point(rawPoint[0], rawPoint[1]);
            graph.add(point);
        }

        return graph;
    }

    /***
     * Pretty prints a graph
     *
     * @param graph {@code ArrayList<Point> graph} the graph to print
     * @param graphName {@code String graphName} the name of the graph
     */
    public static void printGraph(final ArrayList<Point> graph, final String graphName) {
        System.out.println(graphName + ":\n");

        for (Point point: graph) {
            System.out.println(point.toString());
        }

        System.out.println("\n");

    }

    /***
     * Pretty prints a list of edges
     *
     * @param edges {@code ArrayList<Edge> edges} the edges to print
     * @param listName {@code String listName} name of the list
     */
    public static void printEdges(final ArrayList<Edge> edges, final String listName) {
        System.out.println(listName + ":\n");

        for (Edge edge: edges) {
            System.out.println(edge.toString());
        }

        System.out.println("\n");
    }

}
