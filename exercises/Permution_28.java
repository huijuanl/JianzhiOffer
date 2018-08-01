package JianzhiOffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;;
public class Permution_28 {
	 public static ArrayList<String> Permutation(String str) {
		 ArrayList<String>result= new ArrayList<String>();
		 char[]arr=str.toCharArray();
		 process1(arr,0,result);
		 Collections.sort(result);//按字典序进行升序排序
		 return result;
	 }
	    public static void  process(char[]arr,int i,ArrayList<String>result){
	    	if(i==(arr.length-1)){
	    		result.add(String.valueOf(arr));
//                System.out.println(String.valueOf(arr));
                return;
	    	}
	    	for(int j=i;j<arr.length;j++){
	    		swap(arr, i,j);
		    	process(arr, i+1, result);
		    	swap(arr, i, j);
	    	}
	    }
	    public static void  process1(char[]arr,int i,ArrayList<String>result){
	    	if(i==(arr.length-1)){
	    		result.add(String.valueOf(arr));
//                System.out.println(String.valueOf(arr));
                return;
	    	}
	    	for(int j=i;j<arr.length;j++){
	    		boolean HasSame = false;
	    		
	    		for(int k=i;k<j;k++){
	    			if(arr[k]==arr[j]){
	    				HasSame=true;
	    				break;
	    			}
	    		}
	    		if(!HasSame){
	    		swap(arr, i,j);
		    	process1(arr, i+1, result);
		    	swap(arr, i, j);
		    	}
	    	}
	    }
	
       public static void swap(char[]arr,int i,int j){
	    	char tmp =arr[j];
	    	arr[j]=arr[i];
	    	arr[i]=tmp;
	    	
	    }
	    public static void main(String[]args) {
	      String str="abc";
	      ArrayList<String>result= Permutation(str);
	      for(int i=0;i<result.size();i++){
	    	  System.out.println(result.get(i));
	      }
			
		}
}

