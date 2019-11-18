import java.io.IOException;

public class Euler81 {
    public static void main(String[] args) throws IOException {
        //input matrix as 2-D array
        int[][] matrix = EulerToolkit.matrixInput("p081_matrix.txt");
        //store best possible sum for every position in matrix starting top left (greedy approach)
        int[][] sums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    sums[i][j] = matrix[i][j];
                } else {
                    if (i > 0) {
                        if (j > 0) {
                            sums[i][j] = Math.min(sums[i - 1][j], sums[i][j - 1]) + matrix[i][j];
                        } else {
                            sums[i][j] = matrix[i][j] + sums[i - 1][j];
                        }
                    } else {
                        sums[i][j] = matrix[i][j] + sums[i][j - 1];
                    }
                }
            }
        }
        System.out.println(sums[sums.length - 1][sums[0].length - 1]);
    }

}
