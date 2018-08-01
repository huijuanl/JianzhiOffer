package JianzhiOffer;
//回溯法
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
// 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
// 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
// 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
// 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
public class hasPath_66 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || rows < 1 || cols < 1)
            return false;
        char[][] Matrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                Matrix[i][j] = matrix[index];
                index++;

            }
        }
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                boolean[][]vistied = new boolean[rows][cols];
                boolean flag = process(Matrix,i,j,str,0,vistied);
                if(flag)
                    return true;

            }
        }

        return false;
    }
    public boolean process(char[][]matrix,int i,int j,char[]str,int target, boolean[][]vistied){
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length)
            return false;
        if(vistied[i][j])
            return false;
        if(matrix[i][j]!=str[target])
            return false;
        vistied[i][j] = true;
        if(matrix[i][j]==str[target]&&target==str.length-1) {
            return true;
        }
        boolean flag =process(matrix,i+1,j,str,target+1,vistied)
            ||process(matrix,i-1,j,str,target+1,vistied)
            ||process(matrix,i,j-1,str,target+1,vistied)
            ||process(matrix,i,j+1,str,target+1,vistied);
        if(!flag)
            vistied[i][j]=false;
        return flag;



    }
    public static void main(String[] args) {
        hasPath_66 it = new hasPath_66();
        char[] array = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'a', 'b', 'c','b'};
        System.out.println(it.hasPath(array, 3, 4, str));


    }
}
