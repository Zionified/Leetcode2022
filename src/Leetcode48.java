public class Leetcode48 {
    public void rotate(int[][] matrix) {
        //         transpose
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < i; j++) {
                        int lowHalf = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = lowHalf;
                    }
                }
        
        //         flip symmetrically
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length / 2; j++) {
                        int leftHalf = matrix[i][j];
                        matrix[i][j] = matrix[i][matrix.length-j-1];
                        matrix[i][matrix.length-j-1] = leftHalf;
                    }
                }
            }
}
