package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.Scanner;

public class MainLab8_EODReturn{
    public static int EODslove(int[] arr, int[] dp, int n, int i){
        if (i >= n-1) {
            return 0;
        }
        if (dp[i] == 0) {
            dp[i] = Math.max(EODslove(arr, dp, n, i + 1), EODslove(arr, dp, n, i + arr[i] + 1) + arr[i] + 1);
        }
        return dp[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] B = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < B.length; i++) {
            B[i] = sc.nextInt();
        } 
        EODslove(B, dp, n, 0);
        System.out.println(EODslove(B, dp, n, 0));
        sc.close();
    }
}
