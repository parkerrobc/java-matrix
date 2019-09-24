import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class HITS {

    private double[][] L;
    private double[][] Ltranspose;

    private ArrayList<String> hubRank = new ArrayList<String>();
    private ArrayList<String> authorityRank = new ArrayList<String>();

    public void calculateRank(final double[][] webMatrix, final Map<Integer, String> pageNames) throws Exception {

        L = webMatrix;
        MatrixUtils.printMatrix(L, "L");

        Ltranspose = MatrixOperations.transposeMatrix(L);
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
