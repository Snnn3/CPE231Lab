package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo.QuickSelect;

public class QuickSelectMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } 
        int k = sc.nextInt();
        QuickSelect solve = new QuickSelect();
        int ans = solve.Select(arr, k-1, 0, n-1);
        System.out.println(arr[ans]);
        
        sc.close();
    }
}
