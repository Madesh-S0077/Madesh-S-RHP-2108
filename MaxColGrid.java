import java.util.Scanner;
public class MaxColGrid {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows: ");
        int r = sc.nextInt();
        System.out.println("Enter no. of cols: ");
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        long[][] dp = new long[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < r; i++) {
            dp[i][0] = grid[i][0];
        }
        for(int j = 1; j < c; j++) {
            long[] max = getMax(dp, r , j-1);
            for(int i = 0; i < r; i++) {
                if(dp[i][j-1] == max[0]) {
                    dp[i][j] = grid[i][j] + max[1];
                }
                else {
                    dp[i][j] = grid[i][j] + max[0];
                }
            }
        }
        long answer = -1;
        for(int i = 0; i < r; i++) {
            if(dp[i][c-1] > answer ) {
                answer = dp[i][c-1];
            }
        }
        System.out.println(answer);
        sc.close();
    }
    static long[] getMax(long[][] dp, int r, int c) {
        long fmax = -1, smax = -1;
        for(int i = 0; i < r; i++) {
            if(dp[i][c] > fmax) {
                smax = fmax;
                fmax = dp[i][c];
            }
            else if(smax < dp[i][c]) {
                smax = dp[i][c];
            }
        }
        return new long[]{fmax,smax};
    }
}