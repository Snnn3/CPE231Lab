package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo.MaximumSumSubArray;

public class MakeaWishMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        MaximumSumSubArray solve = new MaximumSumSubArray();
        System.out.println(solve.MaxSum(arr, 0, n-1));
        sc.close();
    }
}
