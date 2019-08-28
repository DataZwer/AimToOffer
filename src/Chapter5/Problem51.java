package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-26-14:49
 */

/**
 *@ClassName Problem51
 *@Description TODO: 数组中的逆序对数
 *@Version 1.0
 */

public class Problem51 {
    public static void main(String[] args) {
        int[] a = new int[] {7,5,6,4};
        int[] s = new int[] {0};
        merge(a,0,a.length-1,s);
        System.out.printf("pairs:%d",s[0]);
    }


    public static int[] merge(int[] a,int start, int end,int[] s) {
        if(start<end) {
            int mid = (end+start)/2;
            int[] leftarr = merge(a, start, mid,s);
            int[] rightarr = merge(a, mid+1, end,s);
            int[] newArr = new int[leftarr.length+rightarr.length];

            int i = leftarr.length-1;
            int j = rightarr.length-1;
            int loc = newArr.length-1;
            while(i>=0 && j>=0) {
                if(leftarr[i]<rightarr[j]) {
                    newArr[loc--] = rightarr[j--];

                    // 与归并排序算法不同的地方 加入了count的计算
                    //如果左边的数字大于右边的数字，则说明左边的那个数，大于右边从数组开始到当前数字的所有数 即j+1个数，也就是j+1个逆序对
                }else if(leftarr[i]>rightarr[j]){
                    s[0] = s[0]+j+1;
                    newArr[loc--] = leftarr[i--];
                }
            }

            while(i>=0) {
                newArr[loc--] = leftarr[i--];
            }

            while(j>=0) {
                newArr[loc--] = rightarr[j--];
            }
            return newArr;

        }else {
            return new int[] {a[start]};
        }
    }
}
