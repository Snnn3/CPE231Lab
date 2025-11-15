package th.ac.kmutt.cpe.algorithm.chanon;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] com = new int[n][n];
        int[][] stu = new int[n][n];        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stu[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                com[i][j] = sc.nextInt();
            }
        }



        


        sc.close();
    }
}
