import java.util.Scanner;
public class MaxRowGrid {
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
        for(int j = 0; j < c; j++) {
            dp[0][j] = grid[0][j];
        }
        for(int i = 1; i < r; i++) {
            long[] max = getMax(dp,i-1,c);
            for(int j = 0; j < c; j++) {
                if(dp[i-1][j] == max[0]) {
                    dp[i][j] = grid[i][j] + max[1];
                }
                else {
                    dp[i][j] = grid[i][j] + max[0];
                }
            }
        }
        int answer = -1;
        for(int j = 0; j < c; j++) {
            if(answer < dp[r-1][j]) 
                answer = (int)dp[r-1][j]; 
        }
        System.out.println(answer);
        sc.close();
    }
    static long[] getMax(long[][] dp,int r,int c) {
        long fmax = 0, smax = 0;
        for(int j = 0; j < c; j++) {
            if(dp[r][j] > fmax) {
                smax = fmax;
                fmax = dp[r][j];
            }
            else if(dp[r][j] > smax) {
                smax = dp[r][j];
            }
        }
        return new long[]{fmax,smax};
    }
}
