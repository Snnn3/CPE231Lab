package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

public class MainLab8_ZigZag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[2][n];
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(sc.nextInt());
        }
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 1; i < n; i++) {
            int As = -1;
            int De = -1;
            for (int j = i-1; j >= 0; j--) {
                if (As == -1) {
                    if (x.get(i) > x.get(j)) {
                        if (j == i - 1 ) {
                            dp[0][i] = dp[1][j] + 1; 
                        }else{
                            dp[0][i] = dp[0][j + 1];
                        }
                        As =1;
                    }else if (j == 0){
                        dp[0][i] = 1;
                    }
                }
                if (De == -1) {
                    if (x.get(i) < x.get(j)) {
                        if (j == i - 1 ) {
                            dp[1][i] = dp[0][j] + 1; 
                        }else{
                            dp[1][i] = dp[1][j + 1];
                        }
                        De = 1;
                    }else if (j == 0){
                        dp[1][i] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }   
}
