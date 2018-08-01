package JianzhiOffer;
//字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
//对左区间做镜像翻转，对右区间做镜像翻转，然后总体做镜像翻转
public class leftRotateString_42_2 {
    public String LeftRotateString(String str,int n) {
        if(str.length()<n||n<0)
            return "";
        char[]arr = str.toCharArray();
        Reverse(arr,0,n-1);
        Reverse(arr,n,arr.length-1);
        Reverse(arr,0,arr.length-1);
        return String.valueOf(arr);
    }
    public void Reverse(char[]arr,int start,int end){
        for(int i =start;i<=(start+end)/2;i++){
            swap(arr,i,end+start-i);
        }
    }
    public void swap(char[]arr,int i,int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
