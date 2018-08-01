package JianzhiOffer;

import java.util.HashMap;

public class firstNotRepeatingChar_35 {
	 public int FirstNotRepeatingChar(String str) {
		 HashMap<Character,Integer>map=new HashMap<Character,Integer>();
		 for(int i=0;i<str.length();i++){
			 if(!map.containsKey(str.charAt(i)))
				 map.put(str.charAt(i), 1);
			 else{
				 int val=map.get(str.charAt(i));
				 map.put(str.charAt(i), ++val);
			 } 
		 }
		 for(int i=0;i<str.length();i++){//这里是重点
			 if(map.get(str.charAt(i))==1)
				 return i;
		 }
	        return -1;
	    }
}
