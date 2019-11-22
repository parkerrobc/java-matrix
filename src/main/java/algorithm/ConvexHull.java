package algorithm;

import graph.Edge;
import graph.GraphUtils;
import graph.Point;

import java.util.ArrayList;

/**
 * ConvexHull Algorithms
 *
 * @author parkerrobc
 */
public class ConvexHull {

    /***
     * Prints the convex hull of given {@code double[][] points} using
     * brute force {@code O(n^3)} complexity
     *
     * @param points {@code double[][] points} graph
     */
    public void bruteForceConvexHull(final double[][] points) {

        ArrayList<Point> graph = GraphUtils.createPointArray(points);
        GraphUtils.printGraph(graph, "Graph to Analyze");

        ArrayList<Edge> convexHull = new ArrayList<Edge>();

        int numberOfPointsInGraph = graph.size();

        System.out.println("Starting Convex Hull:\nTotal Points: " + numberOfPointsInGraph +"\n");

        int complexity = 0;

        for (Point pointA : graph) {
            complexity++;
            for (Point pointB : graph) {
                if (!pointA.equals(pointB)) {
                    complexity++;

                    Point terminalPoint = pointB;

                    // Calculating the line between pointA and pointB
                    // equation c = a*x + b*y
                    double a = pointB.getY() - pointA.getY();
                    double b = pointA.getX() - pointB.getX();
                    double c = pointA.getX() * pointB.getY() - pointA.getY() * pointB.getX();

                    // Initializing the right/left counters
                    int right = 0;
                    int left = 0;

                    // We assume that pointA is terminal initially
                    boolean pointAisTerminal = true;

                    for (Point pointC : graph) {
                        if (!pointC.equals(pointA) && !pointC.equals(pointB)) {
                            complexity++;

                            // Calculating cCompare using pointC and the line from pointA to pointB
                            double cCompare = a * pointC.getX() + b * pointC.getY();

                            // if cCompare is greater than c, pointC is on the "right" of the line
                            // if cCompare is less than c, pointC is on the "left" of the line
                            // if cCompare is equal to c, check if pointA is terminal on the line consisting of points A, B, C
                            // if pointA is a terminal, calculate which of the points B or C is further away
                            if (Double.compare(cCompare, c) > 0) {
                                right++;
                            } else if (Double.compare(cCompare, c) < 0) {
                                left++;
                            } else {
                                if (pointAisTerminal) {
                                    if (pointA.isTerminalTo(pointB, pointC)) {
                                        // After all iterations of pointC, the terminalPoint will be the other end of the graph.Edge with pointA
                                        terminalPoint = pointA.returnThePointFurthestAway(terminalPoint, pointC);
                                    } else {
                                        pointAisTerminal = false;
                                    }
                                }
                            }
                        }
                    }

                    // if pointAisTerminal, and if all other points found are exclusively on one side or the other,
                    // we know that the terminalPoint is the other end of the edge in the convexHull
                    // else, we continue processing
                    if (pointAisTerminal) {
                        if ((right == 0 && left > 0) || (left == 0 && right > 0)) {
                            Edge edge = new Edge(pointA, terminalPoint);

                            if (!convexHull.contains(edge)) {
                                convexHull.add(edge);
                            }

                        } else
                            continue;
                    }

                }
            }
        }
        System.out.println("\nConvex Hull Completed:\nComplexity: " + complexity + "\n");

        GraphUtils.printEdges(convexHull, "Convex Hull of Graph");
    }
}


