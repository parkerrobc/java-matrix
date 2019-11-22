package matrix;

import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Basic matrix and vector operations in Java
 *
 * @author parkerrobc
 */
public final class MatrixOperations {

    private MatrixOperations () {

    }

    /***
     * Returns {@code EigenDecomposition} of a {@code double[][] M} matrix
     *
     * @param M {@code double[][] M} matrix
     *
     * @return {@code EigenDecomposition}
     */
    public static EigenDecomposition getEigenDecomposition(final double[][] M) {
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(M);
        EigenDecomposition eigenDecomposition = new EigenDecomposition(realMatrix);
        return eigenDecomposition;
    }

    /***
     * Returns a transposed matrix {@code double[][]} given a {@code double[][] M} matrix
     *
     * @param M {@code double[][] M} matrix to transpose
     *
     * @return {@code double[][]} matrix transpose
     */
    public static double[][] transposeMatrix(final double[][] M) {

        double[][] Mt = new double[M[0].length][M.length];

        for (int i = 0; i < M[0].length; i ++) {
            for (int j = 0; j < M.length; j++) {
                Mt[i][j] = M[j][i];
            }
        }

        return Mt;
    }

    /***
     * Multiplies to matrices {@code double[][] A} X {@code double[][] B} and returns the
     * result as {@code double[][]}
     *
     * @param A {@code double[][] A} matrix to multiply
     * @param B {@code double[][] B} matrix to multiply
     *
     * @return
     *
     * @throws Exception {@code Exception} multiplication not possible
     */
    public static double[][] multiplyMatrices(final double[][] A, final double[][] B) throws Exception {

        validateMultiplicationPossible(A, B);

        double[][] result = new double[A.length][B[0].length];

        for (int i = 0; i < A.length; i++ ) {
            for (int j = 0; j < B[i].length; j++) {
                int dotProduct = 0;

                for (int k = 0; k < B.length; k++) {
                    dotProduct += A[i][k]*B[k][j];
                }

                result[i][j] = dotProduct;
            }

        }

        return result;
    }

    /***
     * Finds the {@code double} determinant of a given matrix {@code double[][] M}
     *
     * @param M {@code double[][] M} matrix to find determinant of
     *
     * @return {@code double} determinant of matrix {@code double[][] M}
     */
    public static double findDeterminant(final double[][] M) {
        int determinate = 0;

        double[] firstRow = M[0];

        for (int i = 0; i < firstRow.length; i++) {
            if (firstRow.length == 2) {
                return M[0][0]*M[1][1] - M[0][1]*M[1][0];
            } else {

                double[][] subMatrix = new double[M.length - 1][M[0].length -1];

                for (int j = 1; j < M.length; j++) {
                    for (int k = 0; k < M[0].length; k++) {
                        if (k > i ) {
                            subMatrix[j-1][k-1] = M[j][k];
                        } else if (k < i) {
                            subMatrix[j-1][k] = M[j][k];
                        }
                    }
                }

                if (i % 2 == 0)
                    determinate += firstRow[i] * findDeterminant(subMatrix);
                else
                    determinate -= firstRow[i] * findDeterminant(subMatrix);
            }
        }

        return determinate;
    }


    /***
     * Returns the {@code double} dot product of vectors {@code double[] ax}
     * and {@code double[] bx} {}
     *
     * @param ax {@code double[] ax} vector
     * @param bx {@code double[] bx} vector
     *
     * @return {@code double} dot product of {@code double[] ax} and {@code double[] bx}
     *
     * @throws Exception {@code Exception} dot product not possible
     */
    public static double dotProduct(final double[] ax, final double[] bx) throws Exception {

        validateDotProductPossible(ax, bx);

        int dotProduct = 0;

        for (int i = 0; i < ax.length; i++) {
            dotProduct += ax[i]*bx[i];
        }

        return dotProduct;
    }

    /***
     * Validates that dot product is possible by comparing the length of {@code double ax}
     * and {@code double bx} vectors
     *
     * @param ax {@code double[] ax} vector
     * @param bx {@code double[] bx} vector
     *
     * @throws Exception {@code Exception} dot product not possible
     */
    private static void validateDotProductPossible(final double[] ax, final double[] bx) throws Exception {
        if (ax.length != bx.length) {
            throw new Exception("Dot Product Not Possible");
        }
    }

    /***
     * Validates if multiplication is possible between to matrices {@code double[][] A} and {@code double[][] B}
     * by comparing {@code A[0].length} and {@code B.length}
     *
     * @param A {@code double[][] A} matrix
     * @param B {@code double[][] B} matrix
     *
     * @throws Exception {@code Exception} multiplication not possible
     */
    private static void validateMultiplicationPossible(final double[][] A, final double[][] B) throws Exception {
        if (A[0].length != B.length) {
            throw new Exception("Multiplication Not Possible");
        }
    }

}
