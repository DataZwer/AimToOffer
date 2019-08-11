package Chapter2;

public class Problem13 {
    public static void main(String[] args) {
        System.out.println(movingCount(10, 5, 10));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;

        boolean[] visted = new boolean[rows*cols];

        int count = movingCountCore(threshold, rows, cols, 0, 0, visted);
        return count;
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visted) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visted)) {

            visted[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row-1, col, visted) +
                    movingCountCore(threshold, rows, cols, row, col-1, visted) +
                    movingCountCore(threshold, rows, cols, row+1, col, visted) +
                    movingCountCore(threshold, rows, cols, row, col+1, visted);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visted) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSun(row) + getDigitSun(col) <= threshold && !visted[row * cols + col]) {
            return true;
        }
        return false;
    }

    private static int getDigitSun(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
