package JianzhiOffer;

//一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

public class findTwoNumsAppearsOnce_40 {
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	    int aXORb=0;  
		for(int i=0;i<array.length;i++){
		aXORb^=array[i];
		}
		//假设a异或b的结果中最后一个1的位置上（第k个位置），a对应的值为1，b对应的值为0
		//把所有第k个位置为1的数进行异或，异或的结果就是a
		int e = getLowFirstEquals1(aXORb);
		int a=0;
		for(int i=0;i<array.length;i++){
			if((e&array[i])==e)
				a^=array[i];
		}
		int b=aXORb^a;
		num1[0]=a;
		num2[0]=b;
	  }
	public static int getLowFirstEquals1(int n){
		//n&(n-1)表示使得n的最后一位1变为0
		//n&~(n-1)表示先对n-1取反，然后与n进行与运算，表示最后一位1所在的位置和值被取出，而其他位为0
		return n&~(n-1);
		
		
	}
	
	  public static void main(String[] args) {
		   int[]arr={1,2,3,4,3,4};
		   int[]num1=new int[1];
		   int[]num2=new int[1];
		   FindNumsAppearOnce(arr,num1,num2);
	        System.out.println(num1[0]+" "+num2[0]);

	    }
	
}



  
