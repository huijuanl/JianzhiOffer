package JianzhiOffer;
//求出1~n的整数中1出现的次数,
public class NumberOf1Between1AndN_32 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int k=1;//k可以换成其他
        int b =0;//b=1表示个位
        int res = 0;
        if(n/((int)(Math.pow(10,b)))==0){
            if(n>=k)
                return 1;
            else return 0;

        }
        while (n/((int)(Math.pow(10,b)))>0){//第b位存在
            int m = n/((int)(Math.pow(10,b)))%10;
            if(m>k){
                res+=(n/(int)(Math.pow(10,b+1))+1)*(int) Math.pow(10,b);
            }
            else if(m<k){
                res+=(n/(int)(Math.pow(10,b+1)))*(int) Math.pow(10,b);
            }
            else {
                res+=(n/(int)(Math.pow(10,b+1)))*(int) Math.pow(10,b)+(n%((int)(Math.pow(10,b)))+1);
            }
            b++;
        }
        return res;
    }
    public static void main(String[]args){
        NumberOf1Between1AndN_32 it = new NumberOf1Between1AndN_32();
        System.out.println(it.NumberOf1Between1AndN_Solution(514));

    }
}
