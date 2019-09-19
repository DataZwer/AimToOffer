package LeetCode.BinarySearch;

public class Problem441_2 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(1));
    }


    public static int arrangeCoins(int n) {
        if (n < 0) return 0;
        int start = 1;
        int end = n;
        int middle = (start + end) >> 1;
        while (start < end) {
            int temp = n - (((1+middle)*middle) >> 1);
            if ((temp > 0 && temp < middle+1) || temp == 0) return middle;
            if (temp < 0) end = middle-1;
            if (temp > middle+1) start = middle+1;
            middle = (start + end) >> 1;
        }
        return middle;
    }
}
