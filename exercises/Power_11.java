package JianzhiOffer;
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
public class Power_11 {
	public double calcucatePower(double base, int exponent) {
	      if(exponent==0)
	          return 1;
	      int i =1;
	      double res = 1.0;
	      while(i<=Math.abs(exponent)){
	          res=res*base;
	          i++;
	      } 
	      if(exponent>=1)
	      return res;
	      else return 1/res;
	    
	  }
}
