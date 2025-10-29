package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.Sorting.QuickSort;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;

public class QuickSortMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        SortContext<Integer> solve = new SortContext<Integer>(new QuickSort<>());
        solve.executeSort(list);
        System.out.println(list);

        sc.close();
    }
}
