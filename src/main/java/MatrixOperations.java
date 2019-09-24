import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;


public final class MatrixOperations {

    private MatrixOperations () {

    }

    public static EigenDecomposition getEigenDecomposition(final double[][] M) {
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(M);
        EigenDecomposition eigenDecomposition = new EigenDecomposition(realMatrix);
        return eigenDecomposition;
    }

    public static double[][] transposeMatrix(final double[][] M) {

        double[][] Mt = new double[M[0].length][M.length];

        for (int i = 0; i < M[0].length; i ++) {
            for (int j = 0; j < M.length; j++) {
                Mt[i][j] = M[j][i];
            }
        }

        return Mt;
    }

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

    public static double findDeterminant(double[][] M) {
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


    public static double dotProduct(final double[] ax, final double[] bx) throws Exception {

        validateDotProductPossible(ax, bx);

        int dotProduct = 0;

        for (int i = 0; i < ax.length; i++) {
            dotProduct += ax[i]*bx[i];
        }

        return dotProduct;
    }

    private static void validateDotProductPossible(final double[] ax, final double[] bx) throws Exception {
        if (ax.length != bx.length) {
            throw new Exception("Dot Product Not Possible");
        }
    }

    private static void validateMultiplicationPossible(final double[][] A, final double[][] B) throws Exception {
        if (A[0].length != B.length) {
            throw new Exception("Multiplication Not Possible");
        }
    }

}
