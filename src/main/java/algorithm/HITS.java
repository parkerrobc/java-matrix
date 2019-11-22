package algorithm;

import matrix.MatrixOperations;
import matrix.MatrixUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Meant to be informative
 * NOT thread safe
 *
 * @author parkerrobc
 */
public class HITS {

    private ArrayList<String> hubRank = new ArrayList<String>();
    private ArrayList<String> authorityRank = new ArrayList<String>();

    /**
     * Calculates PageRank against a given {@code double[][] webMatrix} using algorithm.HITS algorithm
     * where {@code Map<Integer. String> pageNames} uses the value of {@code int i} in {@code webMatrix[i]} to return the
     * {@code String pageName} of the given matrix row
     *
     * @param webMatrix {@code double[][] webMatrix} nxn matrix which uses {@code int 1} in column {@code webMatrix[i][j]}
     *                  to represent that site {@code int i} connects to {@code int j}. {@code int 0} is used to indicate
     *                  a site connected to itself, or does not contain a connection
     * @param pageNames {@code Map<Integer,String> pageNames} contains the {@code String pageName} of web site {@code int i}
     *                  in {@code pageNames.get(i)}
     *
     * @throws Exception {@code Exception} multiplication not possible
     */
    public void calculatePageRank(final double[][] webMatrix, final Map<Integer, String> pageNames) throws Exception {

        double[][] L = webMatrix;

        MatrixUtils.printMatrix(L, "L");

        double[][] Ltranspose = MatrixOperations.transposeMatrix(L);

        MatrixUtils.printMatrix(Ltranspose, "Ltranspose");

        double[][] LtransposexL = MatrixOperations.multiplyMatrices(L, Ltranspose);
        MatrixUtils.printMatrix(LtransposexL, "LtransposexL");

        double[][] LxLtranspose = MatrixOperations.multiplyMatrices(Ltranspose, L);
        MatrixUtils.printMatrix(LxLtranspose, "LxLtranspose");

        double[] hubScores =  MatrixOperations.getEigenDecomposition(LxLtranspose).getEigenvector(0).toArray();
        double[] authorityScores =  MatrixOperations.getEigenDecomposition(LtransposexL).getEigenvector(0).toArray();

        for (int i = 0; i < hubScores.length; i++) {
            hubRank.add(pageNames.get(i));
            authorityRank.add(pageNames.get(i));
        }

        MatrixUtils.printVector(hubScores, "Unsorted hubScores");

        for (int i = 0; i < hubScores.length; i++) {
            for (int j = 1; j < hubScores.length - 1; j++) {
                if (hubScores[j-1] < hubScores[j]) {
                    double tempHubScore = hubScores[j];
                    hubScores[j] = hubScores[j-1];
                    hubScores[j-1] = tempHubScore;

                    Collections.swap(hubRank, j-1, j);
                }
            }
        }

        MatrixUtils.printVector(hubScores, "Sorted hubScores");

        MatrixUtils.printVector(authorityScores, "Unsorted authorityScores");

        for (int i = 0; i < authorityScores.length; i++) {
            for (int j = 1; j < authorityScores.length - 1; j++) {
                if (authorityScores[j-1] < authorityScores[j]) {
                    double tempAuthorityScores = authorityScores[j];
                    authorityScores[j] = authorityScores[j-1];
                    authorityScores[j-1] = tempAuthorityScores;

                    Collections.swap(authorityRank, j-1, j);
                }
            }
        }

        MatrixUtils.printVector(authorityScores, "Sorted authorityScores");

    }

    public ArrayList<String> hubRank() {
        return hubRank;
    }
    public ArrayList<String> authorityRank() {
        return authorityRank;
    }

}
