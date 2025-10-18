package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.Scanner;


public class MainLab8_2 {
    public static int Knapsack(int[][] arr, int i, int j,int[][] ans){
        int value = 0;
        if (i < 0 ) {
            return 0;
        }
        if (ans[i][j] < 0) {
            if (j < arr[i][0]) {
                value = Knapsack(arr, i-1, j, ans);
                //System.out.println(i + " " + value + " " + j);
            }else{
                value = Math.max(Knapsack(arr, i - 1, j, ans), arr[i][1] + Knapsack(arr, i - 1, j - arr[i][0], ans));
                //System.out.println(i + " " + value + " " + j);
            }
            ans[i][j] = value;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] brand = new int[n+1][n+1];
        int[][] table = new int[n+1][t+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= t; j++) {
                table[i][j] = -1;
            }
        } 
        for (int i = 1; i <= n; i++) {
            brand[i][0] = sc.nextInt();
            brand[i][1] = sc.nextInt();
        }
        
        System.out.println(Knapsack(brand, n, t , table));
        sc.close();
    }
}
