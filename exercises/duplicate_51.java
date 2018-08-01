package JianzhiOffer;
//在一个长度为n的数组里的所有数字都在0到n-1的范围内。
// 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
// 请找出数组中任意一个重复的数字。
// 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
//思路一：利用快排的思想(nlogn)
//最优思路：时间复杂度O(n)
//从头到尾遍历数组，若当前下标和当前数字不符合，找到与当前数字相等的下标，若下标存的
// 数字与当前数字不相等，交换，将当前数字放到它应该对应的下标，交换之后继续查看当前下标与
//当前数字是否相等，不相等再交换，停止条件为遍历完整个数组(没找到重复数字)，或是发现 当前数字与当前数字相等
//的下标内的数字相等，则找到一个重复的数

public class duplicate_51 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
     if(length==0)
         return false;
     //一个数最多经过两次交换就可以归位，所以时间复杂度为O(n)
     for (int i =0;i<length;i++){
         while (numbers[i]!=i){
             if(numbers[i]==numbers[numbers[i]]){
                 duplication[0]=numbers[i];
                 return true;
             }
             swap(numbers,i,numbers[i]);
         }

     }
     return false;
    }
    public void swap(int[]arr,int i ,int j){
        int tmp = arr[i];
        arr[i]= arr[j];
        arr[j] = tmp;

    }

}
