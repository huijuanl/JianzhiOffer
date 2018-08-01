package JianzhiOffer;
//可能出现两个大王，两个小王，都记做0
//组成顺子（5张），王可以代替任何数，判断随机抽取的五张牌是否能够组成顺子，能则返回true
//思路：(必须满足两个条件：（1）差小于等于4，（2)除0以外没有重复的数字)
//一次遍历，记录除了王（0）以外的最大值和最小值
//如果最大值与最小值的差大于4，则一定不能组成同花顺
//判断除了王以外，是否有重复的数字，如果有，返回false。
// (如何判断是否有重复的数字，将除了0以外的数字k放在下标k-min的地方，如果不在，则交换到k-min下标的地方，如果k-min
// 下标的位置上已经有了相同的数，说明出现了重复的数字，返回false))
//最后返回true
public class isContinuous_44 {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length > 5 || numbers.length == 0)
            return false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                continue;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }

        }
        if ((max - min) > 4)
            return false;

        for (int i = 0; i < numbers.length; i++) {
            while (((numbers[i] - min) != i) && (numbers[i] != 0)) {//将值为k（且k不为0）的数与下标为k-min的数进行交换
                if (numbers[numbers[i] - min] == numbers[i])
                    return false;
                swap(numbers, i, numbers[i] - min);
            }
        }
        return true;

    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    public static void main(String[] args) {
        isContinuous_44 it = new isContinuous_44();
        int[] arr = {1, 3, 2, 0, 4};
        System.out.println(it.isContinuous(arr));

    }
}
