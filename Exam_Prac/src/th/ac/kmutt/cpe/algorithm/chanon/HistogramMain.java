package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.Sorting.QuickSort;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;

public class HistogramMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextDouble());
        }
        int k = sc.nextInt();
        HistogramSelect solve = new HistogramSelect();
        System.out.println(solve.Select(list, k, b));
        SortContext<Double> solver = new SortContext<Double>(new QuickSort<>());
        solver.executeSort(list);
        System.out.println(list.get(k -1));
        sc.close();
    }
}
