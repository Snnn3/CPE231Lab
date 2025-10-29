package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo.ClosetPair2D;
import th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo.Pair;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.QuickSort;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;

public class CloseMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Pair> Point = new ArrayList<>();
        ClosetPair2D solve = new ClosetPair2D();
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            //System.out.println(x + " " + y);
            Point.add(new Pair(x, y));
        }
        SortContext<Pair> sort = new SortContext<Pair>(new QuickSort<>());
        sort.executeSort(Point);
        for (int i = 0; i < Point.size() ; i++) {
            System.out.println(Point.get(i).getX() + " "+ Point.get(i).getY());
        }
        System.out.println(solve.ClosePair(Point, 0, n - 1));

        sc.close();
    }
}
