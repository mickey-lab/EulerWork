import java.io.IOException;
import java.util.Arrays;

public class Euler82 {

    public static void main(String[] args) throws IOException {
        //input matrix as 2-D array. transpose it to make movement top down instead of left right. makes using arrays easier
        int[][] matrix = EulerToolkit.matrixTranspose(EulerToolkit.matrixInput("p082_matrix.txt"));
        int[][] sums = new int[matrix.length][matrix[0].length];

        //set first row of sums to equal first row of matrix
        for (int j = 0; j < sums[0].length; j++) {
            sums[0][j] = matrix[0][j];
        }
        int[] sumsRow = sums[0];
        int[] temp = new int[sums[0].length];
        //run summer on every element of each row, using the row above from sums as sumRow
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j] = summer(i, j, matrix, sumsRow, true, true, false, true);
            }
            sumsRow = Arrays.copyOf(temp, temp.length);
            sums[i] = Arrays.copyOf(sumsRow, sumsRow.length);
        }
        //find minimum sum in the bottom row of sums
        System.out.println("Min: " + EulerToolkit.getArrayMin(sums[sums.length - 1]));
    }

    public static int summer(int row, int col, int[][] matrix, int[] sumsRow, boolean u, boolean r, boolean d, boolean l) {
        int largeVal = 1000000000;
        //ensure
        if (row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1) {
            return largeVal;
        }
        //make initial min large
        int minU = largeVal, minR = largeVal, minD = largeVal, minL = largeVal;
        /*set minimum sum in each direction
        E.g. minL would be the minimum sum from the left element in the row, whose own sum could either be derived
        from the row of sums above in sums array or from the element to its left as well, hence true for u and l.*/
        if (u) {
            minU = sumsRow[col];
        }
        if (d) {
            minD = summer(row + 1, col, matrix, sumsRow, false, false, true, false);
        }
        if (r) {
            minR = summer(row, col + 1, matrix, sumsRow, true, true, false, false);
        }
        if (l) {
            minL = summer(row, col - 1, matrix, sumsRow, true, false, false, true);
        }
        //find minimum sum from each direction
        return matrix[row][col] + Math.min(minU, Math.min(minR, Math.min(minD, minL)));
    }

}
