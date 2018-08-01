package JianzhiOffer;

public class OddEvenPartition_14 {
	//空间复杂度为O（1），时间复杂度为O（N^2）
    public void reOrderArray(int [] array) {
    int j =-1;//j代表已经排好的奇数区域的下标
    for(int i = 0 ;i<array.length;i++){
        if(array[i]%2==1){
            j++;
            int tmp = array[i];
            for(int k=i;k>j;k--){
              array[k]=array[k-1];
            }
            array[j]= tmp;
        } 
    }
  }
}
