package JianzhiOffer;
//将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
// 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
public class StringToInt_49 {
    public int StrToInt(String str) {
        long res = 0;
        if(str.length()==0)
            return 0;
        if(str.charAt(0)=='-') {
            for(int i =1;i<str.length();i++){
                if(str.charAt(i)<'0'||str.charAt(i)>'9')
                        return 0;
                int k =((int)str.charAt(i)-48);
                long add =(int) Math.pow(10,str.length()-i-1);
                res=res+~(k*add)+1;
                if(res<0x80000000)//0x80000000是一个负数
                    return 0;
            }
        }
        else for(int i =0;i<str.length();i++){
            if(i==0&&str.charAt(0)=='+')
                continue;
            if(str.charAt(i)<'0'||str.charAt(i)>'9')
                return 0;
            int k =((int)str.charAt(i)-48);
            long add =(int) Math.pow(10,str.length()-i-1);
            res=res+(k*add);
            if(res>0x7FFFFFFF)
                return 0;
        }
        return (int) res;
    }
    public static void main(String[]args){
        StringToInt_49 it = new StringToInt_49();
        System.out.println(it.StrToInt("2147483647"));

    }
}
