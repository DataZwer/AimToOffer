package Chapter2;

//读题不仔细，流程没彻底刚清楚就写代码。
public class Problem3 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(Problem3.duplicate1(arr));
    }

    public static boolean duplicate1(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) { //接着扫描下一个数字
                continue;
            } else {
                if(arr[i] == arr[arr[i]]) return true;
                else {
                    temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                }
                i--;
            }
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
        return false;
    }

    public static boolean duplicate2(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] <0 || arr[i] > arr.length-1) return false; //边界条件判断

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return true;
                }
                temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            }
        }
        return false;
    }
}
