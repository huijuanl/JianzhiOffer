package JianzhiOffer;
import java.util.ArrayList;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
//旋转数组的特性：
//
//数组有序就说明考的是二分了
public class MinNumberInRotateArray_8 {
	public static int minNumberInRotateArray(int [] array) {
	if(array.length==0)
		return 0;
	if(array[0]<array[array.length-1])
		return 0;
	int i=0;
	while(i<(array.length-1)){
		if(array[i]>array[i+1])
			break;
		i++;
		
	}
	i++;
	int k=i;
	while(i<(array.length-1)){
		if(array[i]>array[i+1])
			break;
		i++;
		
	}
	if(i==(array.length-1))
		return array[k];
	else return 0;
	
	
	}
	//二分查找
	public static int minNumberInRotateArray2(int [] array) {
		if(array.length==0)
			return -1;
		if(array.length==1)
			return array[0];
		if(array.length==2)
			return array[1];
		int low =0;
		int high= array.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(array[mid]<array[mid-1]&&array[mid]<=array[high])
				return array[mid];//目标值,边界值
			else if(array[mid]>=array[low]&&array[low]>=array[high]){
				low = mid+1;	
			}
			else {
				high=mid-1;
			}
//			else if(array[mid]>=array[low]&&array[low]<=array[high]){
//				high=mid-1;;	
//			}
//			if(array[mid]<=array[high]&&array[low]>=array[high]){
//				high = mid-1;	
//			}
			
			
			
		}
		return -1;
		
		
	}
	 public static void main(String[] args) {
		int[]a={6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,
		         9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,
		         1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,
		         4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335} ;
		System.out.println(minNumberInRotateArray(a));
		System.out.println(minNumberInRotateArray2(a));
		System.out.println("===========");
		 
	 }
}
