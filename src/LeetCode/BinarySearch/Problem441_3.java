package LeetCode.BinarySearch;

public class Problem441_3 {
    public static void main(String[] args) {

    }

    public static int arrangeCoin(int n) {
        double n1 = n;
        long k = (long)Math.sqrt((double)(n1 * 2));
        if(k * k + k > n1 * 2) {
            return (int)k - 1;
        }
        return (int)k;
    }
}
