package LeetCode.BinarySearch;

public class Problem704 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        int target = 3;
        System.out.println(search2(num, target));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0;
        int end = nums.length-1;
        int middle = (start + end) >> 1;
        while (start <= end) {
            if (nums[middle] > target) end = middle - 1;
            else if (nums[middle] < target) start = middle + 1;
            else return middle;
            middle = (start + end) >> 1;
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) start = mid+1;
            else end = mid - 1;
        }
        return start;
    }
}
