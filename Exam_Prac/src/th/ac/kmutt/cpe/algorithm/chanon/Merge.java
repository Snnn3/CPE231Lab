package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.Sorting.BottomUpMergeSort;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;

public class Merge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        SortContext<Integer> solver = new SortContext<Integer>(new BottomUpMergeSort<>());
        solver.executeSort(list);
        System.out.println(list);
        sc.close();
    }
}
