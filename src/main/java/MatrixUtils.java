public final class MatrixUtils {

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

    public static void printVector(final double[] vector, final String vectorName) {
        System.out.println(  vectorName + ":\n");

        String result = "\t|\t";

        for (int i = 0; i < vector.length; i++) {
                result += vector[i] + "\t";
        }

        System.out.println(result + "|\n");
    }
}
