package matrix;

/**
 * Utilities for matrices and vectors
 *
 * @author parkerrobc
 */
public final class MatrixUtils {

    private MatrixUtils() {

    }

    /**
     * Pretty prints a matrix {@code double[][] M} with {@code String matrixName}
     *
     * @param M {@code double[][] M} matrix
     * @param matrixName {@code String matrixName} matrix name
     */
    public static void printMatrix(final double[][] M, final String matrixName) {

        System.out.println(  matrixName + ":\n");

        for (int i = 0; i < M.length; i++) {
            String result = "\t|\t";

            for (int j =0; j <M[i].length; j++) {
                result += M[i][j] + "\t";
            }

            System.out.println(result + "|");
        }

        System.out.println("\n");
    }

    /**
     * Pretty prints a given {@code double[] vector} with {@code String vectorName}
     *
     * @param vector {@code double[] vector} vector
     * @param vectorName {@code String vectorName} vector name
     */
    public static void printVector(final double[] vector, final String vectorName) {
        System.out.println(  vectorName + ":\n");

        String result = "\t|\t";

        for (int i = 0; i < vector.length; i++) {
                result += vector[i] + " ";
        }

        System.out.println(result + "|\n");
    }
}
