package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.Sorting.PancakeSort;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;

public class Pancake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> pan = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pan.add(sc.nextInt());
        }
        SortContext<Integer> solver = new SortContext<Integer>(new PancakeSort<>());
        solver.executeSort(pan);
        System.out.println(pan);
        sc.close();
    }
}
