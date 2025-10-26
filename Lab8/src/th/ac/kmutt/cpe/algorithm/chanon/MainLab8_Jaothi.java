package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.Scanner;


public class MainLab8_Jaothi {
    public static int Knapsack(int[][] arr, int i, int j,int[][] dp){
        int value = 0;
        if (i < 0 ) {
            return 0;
        }
        if (dp[i][j] < 0) {
            if (j < arr[i][0]) {
                value = Knapsack(arr, i - 1, j, dp);
                // System.out.println(i + " " + value + " " + j);
            }else{
                value = Math.max(Knapsack(arr, i - 1, j, dp), arr[i][1] + Knapsack(arr, i - 1, j - arr[i][0], dp));
                // System.out.println(i + " " + value + " " + j);
            }
            dp[i][j] = value;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] brand = new int[n+1][n+1];
        int[][] dp = new int[n+1][t+1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= t; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            brand[i][0] = sc.nextInt();
            brand[i][1] = sc.nextInt();
        }
        
        System.out.println(Knapsack(brand, n, t , dp));
        sc.close();
    }
}
