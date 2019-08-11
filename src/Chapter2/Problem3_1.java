package Chapter2;

public class Problem3_1 {
    private int getDuplication(int number[], int length) {  //"const" ??? java
        if (number == null || length == 0) return -1; //保证健壮性
        int start = 1;
        int end = length - 1;

        while (end >= start) {
            int middle = ((end - start) >> 1) + start; //移位运算
            int count = countRange(number, length, start, middle);

            if(end == start)
            {
                if(count > 1)
                    return start;
                else
                    break;
            }

            if(count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }
        return -1;
    }

    private int countRange(int number[], int length, int start, int end) {
        if (number == null || length == 0) return -1;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (number[i] >= start && number[i] <= end) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem3_1 p = new Problem3_1();
        int[] number = { 2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(p.getDuplication(number, 8));
    }
}