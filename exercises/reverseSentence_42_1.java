package JianzhiOffer;
//“student. a am I”。
// 转换成:“I am a student.”。
public class reverseSentence_42_1 {
    public String ReverseSentence(String str) {
        if(str.length()==0)
            return "";
        char[]arr = str.toCharArray();
        int start =0;
        for(int i =start+1;i<arr.length;i++){
            if(arr[i]==' '){
                Reverse(arr,start,i-1);
                start = i+1;
            }
            else if(i==arr.length-1){
                Reverse(arr,start,i);
            }
        }
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
    public static void main(String[]args){
        reverseSentence_42_1 it = new reverseSentence_42_1();
        System.out.println(it.ReverseSentence("student. a am I"));

    }
}
