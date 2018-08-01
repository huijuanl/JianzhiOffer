package JianzhiOffer;

//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
// 但是不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
// 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
// 请问该机器人能够达到多少个格子？
public class movingCount_67 {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0)
            return 0;
        boolean[][] visited = new boolean[rows][cols];
        return process(threshold, 0, 0, rows, cols, visited);
    }

    public int process(int threshold, int i, int j, int rows, int cols, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols)
            return 0;
        if (visited[i][j])
            return 0;
        visited[i][j] = true;//先标记为已走过(true)然后再进行回溯，否则容易造成死循环
        if (!check(threshold, i, j))
            return 0;
        int sum = process(threshold, i + 1, j, rows, cols, visited) +
                process(threshold, i - 1, j, rows, cols, visited)
                + process(threshold, i, j + 1, rows, cols, visited)
                + process(threshold, i, j - 1, rows, cols, visited);

        return sum + 1;

    }

    public boolean check(int threshold, int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
            if (sum > threshold)
                return false;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
            if (sum > threshold)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        movingCount_67 it = new movingCount_67();
        System.out.println(it.movingCount(2, 3, 2));

    }
}
