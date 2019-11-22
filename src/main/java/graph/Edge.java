package graph;

/**
 * Defines an graph.Edge of a two dimensional graph
 *
 * @author parkerrobc
 */
public class Edge {

    private Point a;
    private Point b;

    public Edge (Point a, Point b) {

        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "[" + a.toString() + "," + b.toString() + "]";
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Edge )) {
            return false;
        }

        Edge edge = (Edge) object;

        if (this.a.equals(edge.a) && this.b.equals(edge.b)) {
            return true;
        } else if (this.a.equals(edge.b) && this.b.equals(edge.a)) {
            return true;
        } else {
            return false;
        }
    }
}
