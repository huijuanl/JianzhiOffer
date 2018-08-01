package JianzhiOffer;
//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
//其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
//一分为二，分别用两个数组来实现
//最后将两个数组相乘
// C[i] = C[i-1]*A[i-1];C[i]=A[0]*...*A[i-1]
// D[i]=D[i+1]*A[i+1];D[i]=A[i+1]*...*A[n-1]
//B[i] = C[i]*D[i]
//时间复杂度为O(n)
public class multiply_52 {
    public int[] multiply(int[] A) {
        int[]C = new int[A.length];
        int[]D = new int[A.length];
        int[]B = new int[A.length];
        C[0] = 1;
        for(int i = 1;i<C.length;i++){
            C[i] = C[i-1]*A[i-1];
        }
        D[A.length-1] = 1;
        for(int i =D.length-2;i>=0;i--){
            D[i]=D[i+1]*A[i+1];
        }
        for(int i =0;i<A.length;i++){
            B[i]=C[i]*D[i];

        }
        return B;
    }
}
