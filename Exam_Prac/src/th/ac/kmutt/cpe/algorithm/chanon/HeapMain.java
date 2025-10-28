package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.Sorting.MinHeapBottomUpSort;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;

public class HeapMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        SortContext<Integer> solve = new SortContext<Integer>(new MinHeapBottomUpSort<>());
        solve.executeSort(list);
        System.out.println(list);
        sc.close();
    }
}
