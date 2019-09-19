package LeetCode.BinarySearch;

public class Problem441 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }

    public static int arrangeCoins(int n) {
        if (n < 0) return 0;

        int t = 1;
        int sum = 0;
        int count = 0;
        while (true) {
            if ((sum+=t) > n) break;
            t++;
            count++;
        }
        return count;
    }
}
