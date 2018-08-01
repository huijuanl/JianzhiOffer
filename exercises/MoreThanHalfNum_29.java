package JianzhiOffer;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
//由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
//可用两种方法实现
//快排的每一次排序，都会使得左边的数小于等于主元，右边的数小于等于主元(主元左右两边都可能存在等于主元的情况)
public class MoreThanHalfNum_29 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0)
            return 0;
        //方法一:
        int target = ArraySelect(array);
        //方法二:
//        int target = QuickSelect(array, 0, array.length - 1);
        //检验异常情况：中位数的个数是否超过了数组的一半
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                num++;
        }
        if (num > array.length / 2)
            return target;
        else return 0;
    }
    //方法一:
    public int ArraySelect(int[]array){
        int target = array[0];
        int times = 1;
        for(int i =1;i<array.length;i++){
            if(array[i]!=target){
                if(times == 0) {
                    target = array[i];
                    times=1;
                }
                else times--;
            }
            else times++;

        }
        return target;

    }
    public int QuickSelect(int[] array, int left, int right) {
        if (left == right && left != array.length / 2)
            return 0;
        int k = partition(array, left, right);
        if (k == array.length / 2)//找到中位数
            return array[k];
        if (k < array.length / 2)
            return QuickSelect(array, k + 1, right);
        else return QuickSelect(array, left, k - 1);
    }

    public int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] <= pivot) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;

    }

    public void swap(int[] array, int a, int b) {
        if (a < 0 || b < 0 || a >= array.length || b >= array.length)
            return;
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        MoreThanHalfNum_29 it = new MoreThanHalfNum_29();
        int result = it.MoreThanHalfNum_Solution(arr);
        System.out.println(result);

    }
}
