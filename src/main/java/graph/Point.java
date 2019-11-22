package graph;

/**
 * Defines a graph.Point on a two dimensional graph
 *
 * @author parkerrobc
 */
public class Point {

    private double x;
    private double y;

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Point )) {
            return false;
        }

        Point point = (Point) object;

        if (Double.compare(this.y, point.getY()) == 0 && Double.compare(this.x, point.getX()) == 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * For {@code graph.Point pointOne} and {@code graph.Point pointTwo} on a line with {@code this}
     * check to see if {@code this} is terminal
     *
     * @param pointOne {@code graph.Point pointOne}
     * @param pointTwo {@code graph.Point pointTwo}
     *
     * @return {@code boolean true} if {@code this} is terminal to {@code pointOne} and {@code pointTwo},
     *         {@code boolean false} otherwise
     */
    public boolean isTerminalTo(final Point pointOne, final Point pointTwo) {

        // pointOne.x > x > pointTwo.x
        if (Double.compare(this.getX(), pointOne.getX()) > 0 && Double.compare(this.getX(), pointTwo.getX()) < 0) {
            return false;
        }

        // pointOne.x < x < pointTwo.x
        if (Double.compare(this.getX(), pointOne.getX()) < 0 && Double.compare(this.getX(), pointTwo.getX()) > 0) {
            return false;
        }

        // pointOne.y > y > pointTwo.y
        if (Double.compare(this.getY(), pointOne.getY()) > 0 && Double.compare(this.getY(), pointTwo.getY()) < 0) {
            return false;
        }

        // pointOne.y < y < pointTwo.y
        if (Double.compare(this.getY(), pointOne.getY()) < 0 && Double.compare(this.getY(), pointTwo.getY()) > 0) {
            return false;
        }

        return true;
    }

    /**
     * Returns the {@code graph.Point point} furthest away from {@code this} out of
     * {@code graph.Point pointOne} and {@code graph.Point pointTwo} using pythagorean theorem
     *
     * @param pointOne {@code graph.Point pointOne}
     * @param pointTwo {@code graph.Point pointTwo}
     *
     * @return {@code pointOne} if furthest from {@code this} or
     *         {@code pointTwo} if furthest from {@code this}
     */
    public Point returnThePointFurthestAway(final Point pointOne, final Point pointTwo) {
        double distanceToPointOne = this.distanceTo(pointOne);
        double distanceToPointTwo = this.distanceTo(pointTwo);

        if (distanceToPointOne > distanceToPointTwo) {
            return pointOne;
        } else {
            return pointTwo;
        }
    }

    /**
     * Calculates distance between {@code this} and {@code graph.Point point} using
     * pythagorean theorem
     *
     * @param point {@code graph.Point point}
     *
     * @return {@code double} distance between {@code this} and {@code graph.Point point}
     */
    private double distanceTo(final Point point) {
        double xSquared = Math.pow((point.getX() - this.x), 2);
        double ySquared = Math.pow((point.getY() - this.y), 2);

        double distance = Math.sqrt(xSquared + ySquared);

        return distance;

    }
}
