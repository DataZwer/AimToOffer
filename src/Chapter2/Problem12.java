package Chapter2;

public class Problem12 {

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd','e', 'h'};
        char[] target = {'a', 'd', 'c', 'e'};

        boolean temp = hasPath(matrix, 3, 4, target);
        // System.out.println(hasPath(matrix,3,4, target,);
        System.out.println(temp);

    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] target) {
        if (matrix.length == 0 || rows < 1 || cols < 1 || target.length == 0) return false;

        // 用一个bool数组记录“痕迹”

        boolean[] visted = new boolean[rows*cols];
        //memset(visted, 0, rows*cols);
        int pathLength = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0 ; col < cols; ++col) {
                if (hasPathCore(matrix, rows, cols, row, col, target, pathLength, visted)) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] target, int pathLength, boolean[] visted) {
        if (pathLength == target.length) return true; // ??

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row*cols+col] == target[pathLength]
                && !visted[row*cols+col]) {
            ++pathLength;
            visted[row*cols+col] = true;

            hasPath = hasPathCore(matrix, rows, cols, row, col-1, target, pathLength, visted) ||
                    hasPathCore(matrix, rows, cols, row-1, col, target, pathLength, visted) ||
                    hasPathCore(matrix, rows, cols, row, col+1, target, pathLength, visted) ||
                    hasPathCore(matrix, rows, cols, row+1, col, target, pathLength, visted);

            if (!hasPath) {
                --pathLength;
                visted[row*cols+col] = false;
            }

            return hasPath;
        }

        return false;
    }
}
