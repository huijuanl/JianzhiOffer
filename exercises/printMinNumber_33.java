package JianzhiOffer;
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
//两种方法:(1)全排列
//(2)自定义一种比较大小的方法，排序(快排nlogn，冒泡n2)
public class printMinNumber_33 {
    public String PrintMinNumber(int [] numbers) {

        process2(numbers);
        StringBuffer str = new StringBuffer();
        for(int i=0;i<numbers.length;i++){
            str.append(numbers[i]);
        }
        return str.toString();
    }
    public void process2(int[]numbers){
        for(int i =0;i<numbers.length;i++)
            for (int j =i;j<numbers.length;j++){
            String a = String.valueOf(numbers[i]);
            String b = String.valueOf(numbers[j]);
            if((a+b).compareTo(b+a)>0){
                swap(numbers,i,j);
            }
        }

    }
//    public String PrintMinNumber(int [] numbers) {
//        String[]m =new String[1];
//        m[0]="";
//        process(numbers,0,m);
//        return m[0];
//    }
    //全排列方法,n!次递归
    public void process(int []numbers,int i,String[]m ){
        if(i== numbers.length-1){
            StringBuffer str = new StringBuffer();
            for(int k = 0;k<numbers.length;k++){
                str.append(numbers[k]);
            }
           String thisStr= str.toString();
            if(m[0].equals("")) {
                m[0] = thisStr;
                return;
            }
            if(m[0].compareTo(thisStr)>0){
                m[0] = thisStr;
                return;
            }



        }
        for(int j = i;j<numbers.length;j++){
            swap(numbers,i,j);
            process(numbers,i+1,m);
            swap(numbers,i,j);
        }

    }
    public void swap(int[]array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }
    public static void main(String[] args) {
        int[] arr = {3334,3,3333332};
        printMinNumber_33 it = new printMinNumber_33();
        String result = it.PrintMinNumber(arr);
        System.out.println(result);

    }
}
