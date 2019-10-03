package Time2;/**
 * @author ZhouWu
 * @create 2019-09-30-14:43
 */

/**
 *@ClassName Problem23
 *@Description TODO
 *@Version 1.0
 */
public class Problem23 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(hasPath(matrix, "BCCE"));
    }

    public static boolean hasPath(char[][] matrix, String str) {
        if (matrix.length == 0 || str == null) return false;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (dfs(matrix, str, 0, i, j)) return true;
        return false;
    }

    private static boolean dfs(char[][] matrix, String str, int u, int x, int y) {
        if (u == str.length()) return true;
        if (matrix[x][y] != str.charAt(u)) return false;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        char t = matrix[x][y];

        matrix[x][y] = '*';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[a].length)
                if (dfs(matrix, str, u+1, a, b)) return true;
        }
        matrix[x][y] = t;

        return false;
    }


}

















