package Chapter2;

public class Problem4 {
    public static void main(String[] args) {

    }

    public boolean find(int[][] array, int target) {
        if (array == null) {  //完整性约束
            return false;
        }
        int row = 0;
        int column = array[0].length-1;
        while (row < array.length && column >= 0) {
            if(array[row][column] == target) {
                return true;
            }
            if(array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return  false;
    }


}


