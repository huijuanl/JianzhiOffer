package JianzhiOffer;
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
//思路：位运算，异或
//两数相异或，获得不考虑进位的值
//两数相与，产生会有进位的结果。实际进位为产生进位结果向前移动一位
//将异或的结果与（两数相与向左移动一位）再次相加
//循环停止条件为进位结果为0
public class Add_47 {
    public int Add(int num1,int num2){
        int sum = num1^num2;
        int carry = (num1&num2)<<1;//进位结果
        while (carry!=0){//产生进位
            num1 = sum;
            num2 = carry;
            sum = num1^num2;
            carry = (num1&num2)<<1;

        }
        return sum;

    }

  //时间复杂度太高，不可取
    public int Add2(int num1,int num2) {
        if(num1==0||num2==0)
            return num1|num2;
        int pre = (num1&1)&(num2&1);
        int res = (num1&1)^(num2&1);
        int k =0;
        while (num1!=0&&num2!=0) {
            num1=num1>>1;
            num2=num2>>1;
            int thisSum = (num1&1)^(num2&1);
            res = res|((thisSum ^ pre)<<1);
            pre = thisSum & pre;
            k++;

        }
        if(num1==0){
            res=res|(num2<<k);
        }
        else {
            res=res|(num1<<k);
        }
        return res;
    }
    public int getKth(int n,int k){//最右边为第0位
        return (n>>k)&1;

    }
    public static void main(String[]args){
        Add_47 it = new Add_47();
        System.out.println(it.Add(111,899));

    }
}
