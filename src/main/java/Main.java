import algorithm.ConvexHull;
import algorithm.HITS;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple Main class. These should really by in Unit tests
 *
 * @author parkerrobc
 */
public class Main {

    public static void main(String[] args) throws Exception {
       HITS();

       ConvexHullBruteForce();

    }

    public static void HITS() throws Exception {
        System.out.println("\n\n****** HITS Algorithm ******\n");

        double[][] L = {
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        HITS hits = new HITS();

        Map<Integer, String> pageNames = new HashMap<Integer, String>();

        pageNames.put(0, "FSU Home Page");
        pageNames.put(1, "Quick Links");
        pageNames.put(2, "Banner");
        pageNames.put(3, "Blackboard");
        pageNames.put(4, "Catalog");
        pageNames.put(5, "Campus Events");
        pageNames.put(6, "Collegiate Link");
        pageNames.put(7, "Course Schedule");
        pageNames.put(8, "Faculty Email");
        pageNames.put(9, "Student Email");
        pageNames.put(10, "tk20");
        pageNames.put(11, "Web4");

        hits.calculatePageRank(L, pageNames);

        System.out.println("\nAuthority Rank:\n\n\t" + hits.authorityRank());
        System.out.println("\nHub Rank:\n\n\t" + hits.hubRank());
    }

    public static void ConvexHullBruteForce() {

        System.out.println("\n\n****** ConvexHull Brute Force Algorithm ******\n");

        double[][] pointsTestOne = {
                {0, 0},
                {0, 1},
                {0, 2},
                {1, 0},
                {1, 1},
                {1, 2},
                {2, 0},
                {2, 1},
                {2, 2},

        };

        ConvexHull convexHull = new ConvexHull();

        convexHull.bruteForceConvexHull(pointsTestOne);

        double[][] pointsTestTwo = {
                {0, 0},
                {1, 1},
                {2, 2},
                {0, 2},
                {2, 0},
        };

        convexHull.bruteForceConvexHull(pointsTestTwo);

    }


}
